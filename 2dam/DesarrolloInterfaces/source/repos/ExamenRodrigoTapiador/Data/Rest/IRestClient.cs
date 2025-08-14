namespace ExamenRodrigoTapiador.Data.Rest;

public interface IRestClient<T>
{
    Task<T?> Get(int id);
    Task<List<T>> GetAll(int offset = 0, int limit = 100);
}
