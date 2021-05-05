# python3

import socket
import json

#importou classe funcionario
from Funcionario import Funcionario

HOST = '127.0.0.1'
PORT = 50000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))

#Criando objeto funcionario para receber os dados
funcionario = Funcionario()#criei o objeto
funcionario.nome = input('Qual o nome do funcionario:' )
funcionario.cargo = input('Qual o cargo:' )
funcionario.salario = input('Qual o salario: ')

# transforma o objeto em json
funcJson = json.dumps(funcionario.__dict__)

s.send(str.encode(funcJson))
data = s.recv(1024)


# Convertendo dados do json para o objeto funcionario
dadosJson = json.loads(data.decode())
funcionario.nome = dadosJson['nome']
funcionario.cargo = dadosJson['cargo']
funcionario.salario = (float(dadosJson['salario']))
print('Nome: ', funcionario.nome, 'Cargo: ', funcionario.cargo, 'Salario ', funcionario.salario) 


                     
