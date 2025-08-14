import multiprocessing

from fastapi import FastAPI
from app.routes import locations, characters, episodes
from app.db.session import engine
from sqlmodel import SQLModel

app = FastAPI()

app.include_router(characters.router)
app.include_router(locations.router)
app.include_router(episodes.router)

def init_db():
    SQLModel.metadata.create_all(engine)

init_db()
