﻿namespace ExamenRodrigoTapiador.Data.Entities;

public class Genre
{
    public int Id { get; set; }
    public string? Name { get; set; }
    public List<Image> Images { get; set; } = [];

}

