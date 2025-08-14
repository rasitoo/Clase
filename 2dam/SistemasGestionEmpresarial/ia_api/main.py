import uvicorn
import multiprocessing

if __name__ == '__main__':
    multiprocessing.freeze_support()
    uvicorn.run(app='app.main:app', host="0.0.0.0", reload=True, port=8000)