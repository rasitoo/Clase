function Menu {
    Write-Host "Opciones:"
    Write-Host "A) Crear ciclo: "
    Write-Host "B) Crear curso:"
    Write-Host "C) Crear alumnos:"
    Write-Host "D) Borrar ciclo:"
    Write-Host "E) Salir:"
}
function Opciones {
    $opcion = ""
    while ($opcion -ne "E") {
        Menu
        $opcion = Read-Host "Introduce una opcion: "
        switch ($opcion) {
            "A" {CrearCiclo}
            "B" {CrearCurso}
            "C" {CrearAlumno}
            "D" {BorrarCiclo}
            "E" {Write-Host "Adios!!"}
            default {Write-Host "Opción no válida"}
        }
    }
}
function CrearCiclo {
    $nombreCiclo = Read-Host "Introduce el nombre del ciclo que quieres anadir"
    $rutaCiclo = Read-Host "Introduce la ruta del ciclo (dejar vacio para ruta por defecto)" 
    if ($rutaCiclo -eq "") {
        $rutaCiclo = ".\"
    } 
    $rutaCiclo = Join-Path $rutaCiclo $nombreCiclo
    New-Item -ItemType Directory -Path $rutaCiclo
}
function CrearCurso {
    $nombreCiclo = Read-Host "Introduce el nombre del ciclo existente al que quieres anadir el curso"
    if (-not (Test-Path -Path $NombreCiclo -PathType Container)) {
        Write-Host "El ciclo '$NombreCiclo' no existe. Crea el ciclo primero."
        return
    }
    $numeroCurso = Read-Host "Introduce el numero del curso que quieres añadir"
    if ($numeroCurso -eq "1" -or $numeroCurso -eq "2"){1
        $rutaCiclo = Join-Path -Path $NombreCiclo -ChildPath "Curso$numeroCurso"       
        New-Item -ItemType Directory -Path $rutaCiclo
    }else {
        Write-Host "Número de curso no válido, debe ser 1 o 2"
    }
}
function CrearAlumno {
    $nombreCiclo = Read-Host "Introduce el nombre del ciclo en el que se encuentra el curso"
    $numeroCurso = Read-Host "Introduce el numero del curso al que quieres añadir un alumno"
    $rutaCiclo = Join-Path -Path $NombreCiclo -ChildPath "Curso$numeroCurso"
    if (-not (Test-Path -Path $rutaCiclo -PathType Container)) {
        Write-Host "El curso $numeroCurso no existe en el ciclo $nombreCiclo o el ciclo no existe."
        return
    }
    $numeroAlumnos = Read-Host "Introduce el numero de alumnos que desea crear"
    if ($numeroAlumnos -gt 0) {
        for ($i = 0; $i -lt $numeroAlumnos; $i++) {
            $rutaAlumno = Join-Path -Path $rutaCiclo -ChildPath "Alumno$i"
            New-Item -ItemType Directory -Path $rutaAlumno

            $alumno = @{
                NumeroAlumno = $i
                Ciclo = $nombreCiclo
                Curso = $numeroCurso
            }
            $rutaCSV = Join-Path $rutaCiclo "\Alumnos.csv"
            $contenido = New-Object PSObject -Property $alumno
            $contenido | Export-Csv -Path $rutaCSV -NoTypeInformation -Append
            Write-Host "Alumno $i creado en $rutaAlumno"
            Write-Host $Alumnos
        }
    }else{
        Write-Host "Error, minimo debe crear un alumno"
    }
}
function BorrarCiclo {
    $nombreCiclo = Read-Host "Introduce el nombre del ciclo que quieres eliminar"
    Remove-Item -Path $nombreCiclo -Recurse
}
Opciones