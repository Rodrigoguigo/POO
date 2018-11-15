class TspEle:

    def __init__(self, id, lat, longi):
        self.prox = object
        self.lat = lat
        self.longi = longi
        self.dist = 0.0
        self.id = id
        self.visitado = False

    def calcDist(self):
        deltax = self.prox.lat - self.lat
        deltay = self.prox.longi - self.longi
        res = ((deltax ** 2) + (deltay ** 2)) ** 0.5
        self.dist = res
        return res

    def setProx(self, no):
        self.prox = no

    def calcDist(self, no):
        deltax = no.lat - self.lat
        deltay = no.longi - self.longi
        res = ((deltax ** 2) + (deltay ** 2)) ** 0.5
        return res

    def setDist(self, tam):
        self.dist = tam
