from http.client import HTTPException

from fastapi import APIRouter, Depends
from sqlmodel import select, Session

from app.models.episode import Episode
from app.db.session import get_session
from app.schemas.episode import EpisodeResponse

router = APIRouter(prefix="/episodes", tags=["Episodes"])

@router.get("/", response_model=list[EpisodeResponse])
async def read_episodes(session: Session = Depends(get_session)):
    return session.exec(select(Episode)).all()
