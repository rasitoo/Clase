from models.persona import Persona


def get_personas():
    return [Persona(id=1, nombre="juan"),
            Persona(id=2, nombre="juanito"),
            Persona(id=3, nombre="juanillo"),
            Persona(id=4, nombre="juanqui")]