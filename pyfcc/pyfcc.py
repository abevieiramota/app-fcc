import re
from collections import namedtuple
from collections import defaultdict
from bs4 import BeautifulSoup

Questao = namedtuple('Questao', 'enunciado')


class Prova:

    ini_questao_re = re.compile(r'^(\d{1,2})\.')
    end_questao_re = re.compile(r'Caderno de Prova')
    ini_item_re = re.compile(r'^\(([A-E])\)')
    rank_symbol_re = re.compile(r'(?<=\d)o')
    enunciado_questao_re = re.compile(r'^(\d{1,2})\.\s*(.*)', re.DOTALL)
    spaces_to_tab_re = re.compile(r'\s{2,}')
    begin_sentence_re = re.compile(r'^[A-Z]')

    def __init__(self, filepath):

        self.divs_questoes = {}
        self._collect_divs(filepath)

    def _ini_questao_match(self, content):

        return Prova.ini_questao_re.match(content)

    def _end_questao_match(self, content):

        return Prova.end_questao_re.match(content)

    def _ini_item_match(self, content):

        return Prova.ini_item_re.match(content)

    def _collect_divs(self, filepath):

        with open(filepath) as prova:

            soup = BeautifulSoup(prova, 'html.parser')

            questao = None
            parte = None

            for div in soup.find_all('div'):

                div_text = div.get_text().strip()

                ini_questao_match = self._ini_questao_match(div_text)
                end_questao_match = self._end_questao_match(div_text)
                ini_item_match = self._ini_item_match(div_text)

                if ini_questao_match:

                    questao = int(ini_questao_match.group(1))
                    self.divs_questoes[questao] = defaultdict(list)
                    parte = 'enunciado'

                elif ini_item_match:

                    parte = ini_item_match.group(1)

                elif end_questao_match:

                    questao = None
                    parte = None

                if parte:

                    self.divs_questoes[questao][parte].append(div)

    def _get_div_text(self, div):

        div_content = div.get_text()

        div_span = div.find('span')

        if div_span and 'v5' in div_span['class']:

            return '\n\n' + div_content.strip()

        if not div_content.strip():

            return ' '

        if 'ffa' in div['class']:

            div_content = Prova.spaces_to_tab_re.sub('\t', div_content.strip())

            return '\n\n' + div_content.rstrip()

        if not Prova.begin_sentence_re.match(div_content):

            return ' ' + div_content

        return div_content

    def _get_enunciado(self, i):

        divs_enunciado = self.divs_questoes[i]['enunciado']

        full_enunciado = ''.join((self._get_div_text(div)
                                 for div in divs_enunciado)).strip()

        full_enunciado = Prova.rank_symbol_re.sub('º', full_enunciado)

        return Prova.enunciado_questao_re.match(full_enunciado).group(2)

    def __getitem__(self, i):

        return Questao(enunciado=self._get_enunciado(i))
