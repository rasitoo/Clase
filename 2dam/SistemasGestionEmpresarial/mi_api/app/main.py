from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class Persona(BaseModel):
    id: int
    nombre: str = "Desconocido"
    edad: int | None = None
    foto_uri: str | None = None

personas = [Persona(id=1, nombre="pepe"), Persona(id=2, nombre="pepa"), Persona(id=3, nombre="pepi"),
            Persona(id=4, nombre="pepo"), Persona(id=5, nombre="pepu"), Persona(id=6, nombre="pepito"),
            Persona(id=7, nombre="pepote"), Persona(id=8, nombre="pepazo")]


@app.get("/personas/{id}")
def read_persona(id: int):
    for persona in personas:
        if persona.id == id:
            return persona
    return {"id": id}

@app.get("/personas/")
def read_productos():
    return personas

