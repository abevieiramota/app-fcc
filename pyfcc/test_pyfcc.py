# -*- coding: utf-8 -*-
import pyfcc

prova = pyfcc.Prova('pdf2htmlEX/'
                    '2016-trt-14-regiao-ro-e-ac-analista-judiciario-'
                    'tecnologia-da-informacao.html')


def test_trt_2016_q1():

    assert prova[1].enunciado == (r'Entre os graves equívocos que podem'
                                  ' se incluir na relação entre um homem'
                                  ' e uma mulher destaca-se, no texto,')


def test_trt_2016_q2():

    assert prova[4].enunciado == ('Considerando-se o contexto,'
                                  ' traduz-se adequadamente o sentido'
                                  ' de um segmento em:')


def test_trt_2016_q3():

    assert prova[16].enunciado == ('Um comerciante compra certa mercadoria'
                                   ' por R$ 149,50 e estabelece o preço de '
                                   'venda levando em consideração que ele quer'
                                   ' obter um lucro de 20% sobre o preço de '
                                   'venda, e que ele deverá pagar um imposto '
                                   'de 15% sobre o mesmo preço de venda.'
                                   ' Nas condições dadas, o preço de venda da '
                                   'mercadoria deverá ser, em R$, de')


def test_trt_2016_q20():

    enunciado = ('Observe os sete primeiros termos de uma sequência numérica:'
                 ' 7, 13, 25, 49, 97, 193, 385, ... . Mantido o mesmo padrão '
                 'da sequência e admitindo-se que o 100º termo seja igual a x,'
                 ' então o 99º termo dela será igual a')

    assert prova[20].enunciado == enunciado


def test_trt_2016_q22():

    enunciado = ('Em um computador que utiliza o Sistema Operacional Linux, '
                 'um Analista digitou um comando e foram mostrados os dados'
                 ' abaixo. '
                 '\n\n'
                 'Active Internet connections (servers and established)'
                 '\n\n'
                 'Proto\tRecv-Q\tSend-Q\tLocal Address\tForeign Address\tState'
                 '\n'
                 'tcp\t0\t0\tlocalhost:30037\t*:*\tLISTEN'
                 '\n'
                 'tcp\t0\t0\tlocalhost:ipp\t*:*\tLISTEN'
                 '\n'
                 'tcp\t0\t0\t*:smtp\t*:*\tLISTEN'
                 '\n'
                 'tcp6\t0\t0\tlocalhost:ipp\t[::]:*\tLISTEN'
                 '\n\n'
                 'O comando digitado foi')

    assert prova[22].enunciado == enunciado
