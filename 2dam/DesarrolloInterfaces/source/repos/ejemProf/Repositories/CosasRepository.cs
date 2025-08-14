using ejemProf.Models;

namespace ejemProf.Repositories
{
    internal class CosasRepository : IRepository<Cosa>
    {
        private List<Cosa> _cosas = new();
        public void Add(Cosa item) => _cosas.Add(item);

        public void Delete(Cosa item) => _cosas.Remove(item);

        public Cosa Get(int id) => _cosas.Find(c => c.Id == id);

        public List<Cosa> GetAll() => _cosas;

        public void Update(Cosa item)
        {
            var cosa = _cosas.Find(c => c.Id == item.Id);
            if (cosa != null)
            {
                cosa.Descripcion = item.Descripcion;
                cosa.Name = item.Name;
                cosa.Id = item.Id;
            }
        }
    }
}
