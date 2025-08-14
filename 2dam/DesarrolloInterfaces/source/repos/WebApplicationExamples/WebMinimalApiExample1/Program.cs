var builder = WebApplication.CreateBuilder(args);

builder.Services.AddEndpointsApiExplorer(); //builder es el contenedor de inversi�n
builder.Services.AddSwaggerGen();

var app = builder.Build();

//mostrar api
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

//http redirige a https
app.UseHttpsRedirection();

//Endpoint
app.MapGet("/products", (int page = 0) =>
{
    List<string> products = ["una cosa", "otra", "otra m�s"];
    return products;
})
.WithName("GetProducts")
.WithOpenApi();

//Endpoint
//app.MapGet("/categories", () =>
//{
//    List<string> forecast = ["una categor�a", "otra", "otra m�s"];
//    return forecast;
//})
//.WithName("GetProducts")
//.WithOpenApi();

//lanza la app
app.Run();

internal record WeatherForecast(DateOnly Date, int TemperatureC, string? Summary)
{
    public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);
}
