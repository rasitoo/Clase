from sqlmodel import SQLModel


class EpisodeCreate(SQLModel):
    location_id : int | None = None
    character_id : int | None = None

class EpisodeResponse(EpisodeCreate):
    id: int
