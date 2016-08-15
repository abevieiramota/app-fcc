# -*- coding: utf-8 -*-
import pyfcc


def test_trt_2016():

    prova = pyfcc.Prova('pdf2htmlEX/'
                        '2016-trt-14-regiao-ro-e-ac-analista-judiciario-'
                        'tecnologia-da-informacao.html')

    assert prova[1].enunciado == ('Entre os graves equívocos que podem'
                                  ' se incluir na relação entre um homem'
                                  ' e uma mulher destaca-se, no texto,')

    assert prova[4].enunciado == ('Considerando-se o contexto,'
                                  ' traduz-se adequadamente o sentido'
                                  ' de um segmento em:')
