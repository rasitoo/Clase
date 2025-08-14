from pydantic import BaseModel


class Persona(BaseModel):
    nombre: str = "Desconocido"
    apellido: str | None = None
    foto: str | None = None
    edad: int | None = None

class PersonaRead(Persona):
    id: int | None = 0

class PersonaCreate(Persona):
    pass

class PersonaUpdate(Persona):
    nombre: str|None