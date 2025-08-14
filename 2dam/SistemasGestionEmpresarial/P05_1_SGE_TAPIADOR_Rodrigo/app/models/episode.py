from typing import Optional

from sqlmodel import SQLModel, Field


class Episode(SQLModel, table=True):
    id : Optional[int] = Field(default=None, primary_key=True)
    location_id : Optional[int] = Field(foreign_key="location.id")
    character_id : Optional[int] = Field(foreign_key="character.id")