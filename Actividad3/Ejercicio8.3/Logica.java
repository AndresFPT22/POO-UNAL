public class Logica {

    public static class Cilindro{

        public static double volumenCilindro(double radio, double altura){

        return Math.PI*altura*Math.pow(radio, 2);

        }

        public static double superficieCilindro(double radio, double altura){

            return Math.PI*2*radio*(radio+altura);

        }
    }

    public static class Cubo{

        public static double volumenCubo(double longitud){

            return Math.pow(longitud, 3);

        }

        public static double superficieCubo(double longitud){

            return 6*Math.pow(longitud, 2);
        }
    }

    public static class Esfera{

        public static double volumenEsfera(double radio){

            return (4.0/3.0)*Math.pow(radio, 3)*Math.PI;

        }

        public static double superficieEsfera(double radio){

            return 4*Math.PI*Math.pow(radio, 2);

        }
    }

    public static class Piramide{

        public static double volumenPiramide(double ancho, double largo, double altura){

            return (ancho*largo*altura)/3;

        }

        public static double superficiePiramide(double ancho, double largo, double apotema){

            double areaBase = ancho*largo;
            double areaLateral = ancho*apotema + largo*apotema;

            return areaBase + areaLateral;
        }
    }

    public static class Prisma{

        public static double volumenPrisma(double area, double altura){

            return area*altura;

        }

        public static double SuperficiePrisma(double area, double altura){

            double areaLateral = 4*Math.sqrt(area)*altura;

            return areaLateral+2*area;
        }
    }
    
}
