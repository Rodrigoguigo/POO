from Contas import TspEle
total=0
f = open("coord.txt", "r")

aux = f.read().split("\n")
f.close()
cidades = []
for i in range(len(aux)):
    aux[i] = aux[i].split(" ")
    aux[i] = list(map(int, aux[i]))
    cidades.append(TspEle(aux[i][0], aux[i][1], aux[i][2]))

for i in range(len(cidades)):
    if i == 0:
        selec = cidades[0]
    else:
        selec = selec.prox

    menor = 0
    for j in range(len(cidades)):
        ajuda = selec.calcDist(cidades[j])
        if selec != cidades[j] and not (cidades[j].visitado):
            if menor == 0:
                menor = []
                menor.append(ajuda)
                menor.append(cidades[j])
            elif menor[0] > ajuda:
                menor[0] = ajuda
                menor[1] = cidades[j]
    if i != len(cidades)-1:
        total += menor[0]
        selec.setDist(menor[0])
        selec.setProx(menor[1])
    selec.visitado = True
    print(str(selec.id))
else:
    total += selec.calcDist(cidades[0])
    selec.setDist(selec.calcDist(cidades[0]))
    selec.setProx(cidades[0])
    print("1")
    print(total)




