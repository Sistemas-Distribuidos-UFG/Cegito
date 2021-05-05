class Funcionario:
    def _init_(self, nome, cargo, salario):
        self.nome = nome
        self.cargo = cargo
        self.salario = salario

        
    def setNome(self, nome):
        self.nome = nome

    def setCargo(self, cargo):
        self.cargo = cargo

    def setSalario(self, salario):
        self.salario = salario

    def getNome(self, nome):
        return self.nome

    def getCargo(self, cargo):
        return self.cargo

    def getSalario(self, salario):
        return self.salario
