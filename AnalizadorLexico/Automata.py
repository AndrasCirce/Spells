tokens = ['ID','NUMBER','PLUS','MINUS', 'TIMES',
            'ODD', 'ASSING', 'NE', 'LT', 'LTE', 'GT',
            'GTE', 'LPARENT', 'RPARENT', 'COMMA',
            'SEMICOLOM', 'DOT', 'UPDATE']

    #Diccionario de palabras clave valor
palabrasResev = {'public':'PUBLIC', 'for':'FOR',
                     'if':'IF', 'void':'VOID',
                     'while':'WHILE', 'do':'DO',
                     'class':'CLASS', 'const':'CONST',
                     'int':'INT', 'float':'FLOAT',
                     'static':'STATIC', 'char':'CHAR', 'else':'ELSE',
                     'main':'MAIN'}

class Automata:
   
    def __init__(self, cadena):
        self.cadena = cadena

    def lector(self):
        #crea variable de estado
        self.estado = 0
        #crea variable para contener palabras de la cadena
#        p = ''
        #crea ciclo que lea la cadena en cada iteracion
        for i in range (0, len(self.cadena)):
            
            #crea una variable trancision
            self.trancision = self.cadena[i]
            if self.estado == 0:
                if str.isalpha(self.trancision): 
                    if str.islower(self.trancision) or str.isupper(self.trancision):
                        self.estado = 1
                        print("voy a edo ", self.estado)
                elif str.isdigit(self.trancision):
                    self.estado = 3
                    print("voy a edo ", self.estado)
                elif str.isascii(self.trancision):
                    if self.trancision == ":":
                        self.estado = 8
                        print("voy a edo ", self.estado)
                    elif self.trancision == ";" or self.trancision == "+":
                        self.estado = 10
                        print("voy a edo ", self.estado)
                    else:
                        self.estado = 7
            #cambio de estado
            elif self.estado == 1:
                if str.isalnum(self.trancision):
                    self.estado = 1
                    print(str.isalnum(self.trancision))
                    return True
                '''else:
                    self.estado = 2
                    print("entro a estado 2")
                    return True'''
            #cambio de estado
            elif self.estado == 3:
                if str.isdigit(self.trancision):
                    self.estado = 3
                    return True
                elif str.isascii(self.trancision) and self.trancision == ".":
                    self.estado = 4
                    return False
                else:
                    self.estado = 7
                    return False
            #cambio de estado        
            elif self.estado == 4:
                if str.isdigit(self.trancision):
                    self.estado = 5
                else:   
                    self.estado = 7
                    return False
            #cambio de estado
            elif self.estado == 5:
                if str.isdigit(self.trancision):
                    self.estado = 5
                    return True
                else:
                    self.estado = 6
                    return True
            #cambio de estado
            elif self.estado == 8:
                if str.isascii(self.trancision) and self.trancision == "=":
                     self.estado = 9
                     return True
                else:
                    self.estado = 7
                    return False
            elif str.isascii(self.trancision): 
                if self.trancision == ";" or self.trancision == "+":
                    self.estado = 10
                    return True
                  

#----------------------------------------------------------------------------------------------------------
def main():
        cadena = input("Ingresa un texto: ")    
        AFD = Automata(cadena)
        if AFD.lector():
            print("La cadena", cadena, " es valida","\n")
        else:
            print("La cadena ", cadena, " no es valida","\n")
if __name__ == "__main__":
        main() 