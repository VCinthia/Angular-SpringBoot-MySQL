-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 13-03-2023 a las 16:41:37
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carrito`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `descripcion`, `imagen`, `nombre`, `precio`) VALUES
(1, 'Cuphead es un videojuego perteneciente al género de corre y dispara, publicado por la empresa canadiense StudioMDHR.', 'https://image.api.playstation.com/vulcan/img/cfn/11307fd0s0uyV-ba4dy5E9qskf6CIntl28sAerYTFbYC7vPUBrfgp7zokliHVbVoJ5ghylOBamo2Q2i5pbEYxQKFnSsiLHaY.png', 'CupHead', 180),
(2, 'Genshin Impact es un videojuego de rol de acción de mundo abierto y gratuito, con una mecánica de monetización de gacha para conseguir elementos adicionales como personajes especiales y armas.', 'https://www.latercera.com/resizer/l9vcG-Wo52Qma3LsLOGLctp6qyk=/900x600/smart/cloudfront-us-east-1.images.arcpublishing.com/copesa/NYELLAJDXFGLTLFZCGFB2Y2WT4.jpg', 'Genshin Impact', 10),
(3, 'Honkai Impact 3rd es un videojuego de acción de rol gratuito con mecánica gacha desarrollado por HoYoverse lanzado por primera vez en China el 14 de octubre del 2016, y lanzado globalmente el 28 de marzo de 2018.', 'https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2021/05/honkai-impact-3rd-2342195.jpg?itok=ntmWtVqx', 'Honkai Impact 3rd', 100),
(4, 'FIFA 23 es un próximo videojuego de simulación de fútbol publicado por Electronic Arts . Será la trigésima y última entrega de la serie FIFA que será desarrollada por EA Sports.', 'https://cloudfront-us-east-1.images.arcpublishing.com/infobae/2SRVZDMIEBDFRAS4WDAEPEZ7OI.jpeg', 'EA SPORTS FIFA 23', 150),
(5, 'Slime Rancher 2 es un videojuego de aventura de simulación de vida en primera persona desarrollado y publicado por el estudio independiente estadounidense Monomi Park. Slime Rancher 2 es la secuela directa de su predecesor, Slime Rancher.', 'http://s.gamer-info.com/gl/s/l/i/m/slime-rancher-2_ba.jpg', 'Slime Rancher 2', 80);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
