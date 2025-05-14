
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    rol ENUM('Administrador', 'Consultor', 'Cliente') NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Empresas (
    id_empresa INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    sector VARCHAR(100),
    direccion TEXT,
    telefono VARCHAR(20),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE SET NULL
);

CREATE TABLE Proyectos_Auditoria (
    id_auditoria INT AUTO_INCREMENT PRIMARY KEY,
    id_empresa INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    estado ENUM('Pendiente', 'En proceso', 'Finalizado') NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES Empresas(id_empresa) ON DELETE CASCADE
);

CREATE TABLE Evaluaciones_Auditoria (
    id_evaluacion INT AUTO_INCREMENT PRIMARY KEY,
    id_auditoria INT NOT NULL,
    resultado TEXT,
    fecha_evaluacion DATE NOT NULL,
    FOREIGN KEY (id_auditoria) REFERENCES Proyectos_Auditoria(id_auditoria) ON DELETE CASCADE
);

CREATE TABLE Vacantes (
    id_vacante INT AUTO_INCREMENT PRIMARY KEY,
    id_empresa INT NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('Abierta', 'Cerrada') DEFAULT 'Abierta',
    FOREIGN KEY (id_empresa) REFERENCES Empresas(id_empresa) ON DELETE CASCADE
);

CREATE TABLE Candidatos (
    id_candidato INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    experiencia TEXT
);

CREATE TABLE Seleccion_Personal (
    id_seleccion INT AUTO_INCREMENT PRIMARY KEY,
    id_candidato INT NOT NULL,
    id_vacante INT NOT NULL,
    estado ENUM('Postulado', 'Entrevista', 'Contratado', 'Rechazado') DEFAULT 'Postulado',
    fecha_aplicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_candidato) REFERENCES Candidatos(id_candidato) ON DELETE CASCADE,
    FOREIGN KEY (id_vacante) REFERENCES Vacantes(id_vacante) ON DELETE CASCADE
);

CREATE TABLE Registro_Actividades (
    id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    descripcion TEXT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE SET NULL
);
SHOW TABLES;
