class Automata2:
    def __init__(self, cadena):
        self.cadena = cadena

    def lector(self):
        #crea variable de estado
        self.estado = 0
        #crea variable para contener palabras de la cadena
        p = ""
        #crea ciclo que lea la cadena en cada iteracion
        for i in range (0, len(self.cadena)):
            #crea variable para transiciones
            self.trancision = self.cadena[i] 
            if self.estado == 0:
                #definimos si el caracter leido es alfabetico
                if str.isalpha(self.trancision): 
                    #instanciamos el contenedor con cada iteracion del ciclo
                    p += self.trancision
                    #definimos a que estado ira
                    self.estado = 0
                    #print("voy a edo ", self.estado)
                    #imprimimos p
                    print(p)
                #definimos si el caracter leido es un espacio
                elif str.isspace(self.trancision):
                    #confimamos que es un espacio    
                    print ("hay un espacio? ", str.isspace(self.trancision))
                    #reemplazamos el espacio con un un caracter vacio y obtenemos la sieguiente letra
                    p.replace(" ","")
                    #asignamos a p la letra despues del espacio
                    p = self.cadena[len(p)]
                    #imprimos p
                    print(p)
                    self.estado = 0
                    print("voy a edo ", self.estado)
                    #return True
#__________________________________________________________________________________________________________________________
def main():
        cadena = input("Ingresa un texto: ")    
        AFD = Automata2(cadena)
        if AFD.lector():
            print("La cadena", cadena, " es valida","\n")
        else:
            print("La cadena ", cadena, " no es valida","\n")
if __name__ == "__main__":
        main() 