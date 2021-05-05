# python3

import socket
import json

from Funcionario import Funcionario

HOST = 'localhost'
PORT = 50000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen()
print('Aguardando conexão de um cliente')
conexao, endereco = s.accept()

print('Conetado em', endereco)

while True:
    data = conexao.recv(1024)
    if not data:
        print('Fechando a conexão')
        conexao.close()
        break
    
    # recebendo e tratando os dados
    funcionario = Funcionario()

    # Convertendo dados do json para o objeto funcionario
    dadosJson = json.loads(data)
    funcionario.nome = dadosJson['nome']
    funcionario.cargo = dadosJson['cargo']
    funcionario.salario = (float(dadosJson['salario']))
    
    if funcionario.cargo == 'operador':
        funcionario.salario = (funcionario.salario * 1.20)
    elif funcionario.cargo == 'programador':
        funcionario.salario = (funcionario.salario * 1.18)

    
    # transforma objeto em json
    funcJson = json.dumps(funcionario.__dict__)
    conexao.send(str.encode(funcJson))

              
