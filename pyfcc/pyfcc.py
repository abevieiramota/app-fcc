import re
from collections import namedtuple
from bs4 import BeautifulSoup

ini_questao = re.compile(r'^(\d{1,2})\.')
ini_item = re.compile(r'^\(([A-E])\)')
end_item_E = re.compile(r'Caderno de Prova')

soup = BeautifulSoup(open('pdf2htmlEX/2016-trt-' +
                          '14-regiao-ro-e-ac-analista-judiciario-tecnologia' +
                          '-da-informacao.html'), 'html.parser')

Questao = namedtuple('Questao', 'enunciado')


class Prova:

    def __init__(self, filepath):

        with open(filepath) as prova:

            soup = BeautifulSoup(prova, 'html.parser')

            self.divs_questoes = {}

            questao = None
            pos_item = False

            for div in soup.find_all('div'):

                is_ini_questao = ini_questao.match(div.get_text())

                if is_ini_questao:

                    questao = is_ini_questao.group(1)
                    self.divs_questoes[questao] = []
                    pos_item = False

                if ini_item.match(div.get_text()):

                    pos_item = True

                if not div.get_text().strip() and pos_item:

                    questao = None

                if questao:

                    self.divs_questoes[questao].append(div)

    def __getitem__(self, i):

        return Questao(enunciado=self.divs_questoes[str(i)][0].get_text())

        # return Questao(enunciado='Entre os graves equívocos que podem'
        #                          ' se incluir na relação entre um homem'
        #                          ' e uma mulher destaca-se, no texto,')
