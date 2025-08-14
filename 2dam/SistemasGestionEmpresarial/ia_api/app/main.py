from fastapi import FastAPI

from models.persona import PersonaCreate, PersonaRead
from services.persona_service import get_personas

app = FastAPI()

@app.get("/")
def read_home():
    return "Hola"

@app.get("/personas/")
def read_personas(nombre: str | None = None, edad: int | None = None):
    return get_personas()

@app.get("/personas/{item_id}")
def read_persona(id: int):
    for persona in get_personas():
        if persona.id == id:
            return persona

@app.post("/personas/", response_model=PersonaRead)
def create_persona(persona:PersonaCreate):
    return PersonaRead(**persona.model_dump())
    #return get_personas()[1]
