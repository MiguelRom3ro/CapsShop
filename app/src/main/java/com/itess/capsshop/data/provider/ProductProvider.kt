package com.itess.capsshop.data.provider

import com.itess.capsshop.data.CategoryCaps
import com.itess.capsshop.data.Product

class ProductProvider {
    companion object{
        private val productList = listOf(
            Product(
                0,
                "NFL Seattle Seahawks",
                CategoryCaps.NFL,
                false,
                0,
                "Esta gorra New Era 39THIRTY de Seattle Seahawks de la colección NFL Sideline Historic " +
                        "presenta el logotipo retro de los Seahawks y el año de su fundación bordado en los paneles" +
                        " frontales, y el flag de New Era bordado en el lado izquierdo. Apoya a tu equipo y cómprala ya.",
                899.00,
                "https://www.newera.mx/cdn/shop/files/60406678_39THIRTY_M3930NFLSLHIS23_SEASEACC_OTC_3QL_900x.png?v=1693356907"),
            Product(
                1,
                "NFL Salute to Service 2023",
                CategoryCaps.NFL,
                false,
                0,
                "Esta gorra New Era 39THIRTY de Seattle Seahawks de la colección NFL Salute to Service " +
                        "2023 presenta un diseño de corona beige con el logotipo de los Seahawks bordado en los " +
                        "paneles frontales, la bandera de Estados Unidos del lado derecho, undervisor camuflaje, el " +
                        "logo de la NFL al reverso y el flag de New Era en el lado izquierdo. Cómprala ya.",
                799.00,
                "https://www.newera.mx/cdn/shop/files/60423274_39THIRTY_M3930NFLSTS23_SEASEA_STN_3QR_900x.png?v=1697134457"),
            Product(
                2,
                "NFL Pittsburgh Steelers",
                CategoryCaps.NFL,
                false,
                0,
                "Esta gorra New Era 59FIFTY de Pittsburgh Steelers de la colección NFL Sideline Historic presenta " +
                        "el logotipo retro de los Steelers bordado en los paneles frontales, un parche con el año de su" +
                        " fundación del lado derecho, y el flag de New Era bordado en el lado izquierdo. Apoya a tu equipo " +
                        "y cómprala ya.",
                1299.000,
                "https://www.newera.mx/cdn/shop/files/60406880_59FIFTY_M5950NFLSLHIS23_PITSTECC_OTC_3QL.png?v=1693416576"),
            Product(
                3,
                "NBA Golden State Warriors",
                CategoryCaps.NBA,
                false,
                0,
                "Esta gorra New Era 59FIFTY de Golden State Warriors " +
                        "de la colección NBA Monster Curse presenta un diseño en color " +
                        "café con la visera más oscura, el logotipo de los Warriors bordado " +
                        "en los paneles frontales, detalles tipo zoombie en las costuras, undervisor " +
                        "verde, y el flag de New Era bordado en el lado izquierdo. Dale un toque a " +
                        "tu outfit esta temporada y cómprala ya",
                1199.00,
                "https://www.newera.mx/cdn/shop/files/60487858_59FIFTY_LIFESTYLEENERGY_GOLWAR_OTC_3QL.png?v=1696549367"),
            Product(
                4,
                "NBA Athleisure 9FORTY Strapback",
                CategoryCaps.NBA,
                false,
                0,
                "Esta gorra New Era 9FORTY de Chicago Bulls de la colección " +
                        "NBA Athleisure presenta el logo de los Bulls bordado en los paneles" +
                        " frontales, visera curva y en la parte trasera broche ajustable. Dale un " +
                        "toque de estilo a tu a outfit. Cómprala ya.",
                649.00,
                "https://www.newera.mx/cdn/shop/files/60372036_9FORTY_M940GRAYPOPE3_CHIBUL_GRA_3QL_900x.png?v=1692998912"),
            Product(
                5,
                "NBA Chicago Bulls Olive Collection",
                CategoryCaps.NBA,
                false,
                0,
                "Esta gorra New Era 9FORTY de Chicago Bulls de Olive Collection presenta " +
                        "el logotipo de los Bulls bordado en los paneles frontales, su distintivo color " +
                        "verde olivo realzará tu estilo, permitiéndote lucirla durante cualquier época del " +
                        "año. Cómprala ya.",
                649.00,
                "https://www.newera.mx/cdn/shop/files/60350779_9FORTY_Q123_20BOOKING_20PROGRAM_20AU_CHIBUL_NEW_20OLIVE_3QL_900x.png?v=1688589724"),
            Product(
                6,
                "MBL New York Yankees Classics",
                CategoryCaps.MBL,
                false,
                0,
                "Que tu fan interior se exprese de todas las maneras posibles con esta gorra 59FIFTY de New York " +
                        "Yankees en color blanco sobre blanco y undervisor en gris. Cómprala ya.",
                999.00,
                "https://www.newera.mx/cdn/shop/files/11591120_59FIFTY_MLBBASICFITTED_NEYYAN_WHI_3QL_900x.jpg?v=1689024389"),
            Product(
                7,
                "MBL Los Angeles Dodgers Cooperstown",
                CategoryCaps.MBL,
                false,
                0,
                "Esta gorra New Era 9FORTY AF de Los Angeles Dodgers de la colección MLB Cooperstown " +
                        "presenta un diseño otoñal en color verde con el logotipo de los Dodgers " +
                        "naranja bordado en los paneles frontales, un parche conmemorativo, y el flag de " +
                        "New Era bordado en el lado izquierdo. Cómprala ya.",
                649.00,
                "https://www.newera.mx/cdn/shop/files/60416093_9FORTYAF_Q323_20BOOKING_20PROGRAM_20AU_LOSDODCO_DARK_20GREEN_3QR_900x.png?v=1698191631"),
            Product(
                8,
                "MBL Philadelphia Phillies Authentic Collection",
                CategoryCaps.MBL,
                false,
                0,
                "New Era es la gorra oficial de MLB. Y esta gorra original de juego " +
                        "es la muestra más clara. Compra esta 59FIFTY Cerrada de Philadelphia Phillies, " +
                        "colección que llamamos AC, como la que ves noche tras noche en los diamantes de las Grandes Ligas.",
                899.00,
                "https://www.newera.mx/cdn/shop/products/9210505822238_b93a81ef-4986-45fe-8019-153a6bbd325a_900x.jpg?v=1667131374"),
            Product(
                9,
                "Hogwarts Harry Potter Collection",
                CategoryCaps.INDEFNINE,
                true,
                15,
                "Esta gorra New Era 59FIFTY del Colegio Hogwarts de Magia y Hechicería de la Harry" +
                        " Potter Collection presenta el logotipo de Hogwarts bordado del lado derecho, la inicial " +
                        "y el nombre bordados en los paneles frontales, y el flag de New Era bordado en el lado " +
                        "izquierdo. Arma tu colección y cómprala ya.",
                999.00,
                "https://www.newera.mx/cdn/shop/files/60493746_59FIFTY_LIFESTYLEENERGY_HARPOT_OTC_3QR_900x.png?v=1701130374"),
            Product(
                10,
                "Rick And Morty Portal Gun",
                CategoryCaps.INDEFNINE,
                true,
                10,
                "Esta gorra New Era 59FIFTY de la colección Rick And Morty " +
                        "presenta un diseño all over con Rick y Morty en el portal" +
                        " bordados en los paneles frontales, el undervisor con el diseño del portal, " +
                        "y el flag de New Era bordado en el lado izquierdo. No te pierdas este artículo " +
                        "de colección. Cómprala ya.",
                999.00,
                "https://www.newera.mx/cdn/shop/files/14117007_59FIFTY_RICK_AND_MORTY_BLK_3QR_900x.png?v=1700608577"),
            Product(
                11,
                "Dragon Ball Z Fusion",
                CategoryCaps.INDEFNINE,
                true,
                15,
                "Esta gorra New Era 59FIFTY de la colección Dragon Ball Z presenta un diseño negro con " +
                        "la fusión de Goten y Trunks bordada en los paneles frontales, Gotenks al reverso, una " +
                        "esfera del dragón del lado derecho y el flag de New Era bordado en el lado izquierdo. " +
                        "No te pierdas este artículo de colección.",
                1100.00,
                "https://www.newera.mx/cdn/shop/files/13948487_59FIFTY_DBZ_FUSION_BLK_3QR_1296x.png?v=1700608692"),
            Product(
                12,
                "NFL New England Patriots 301",
                CategoryCaps.NFL,
                true,
                10,
                "Prepárate para conocer a los nuevos talentos de la NFL con esta gorra New " +
                        "Era 59FIFTY de New England Patriots NFL Draft 2023 la cual presenta un script " +
                        "de los Patriots bordado en los paneles frontales, el escudo de la NFL en el lado derecho y " +
                        "el logo del equipo en la parte trasera. Cómprala ya.",
                999.00,
                "https://www.newera.mx/cdn/shop/products/60352077_59FIFTY_NFL23DRAFT5950_NEEPAT_OTC_3QR_900x.png?v=1682014380"),
            Product(
                13,
                "NFL Staple X New England Patriots ",
                CategoryCaps.NFL,
                true,
                20,
                "Esta gorra New Era 59FIFTY de New England Patriots de la colección Staple X NFL presenta el logo " +
                        "de los Patriots bordado en los paneles frontales entre un script oversize de Staple, " +
                        "el logo de Staple Pigeon en el lado derecho y el logo de la NFL a juego con un bordado inspirado en " +
                        "Staple en la parte trasera. Cómprala ya.",
                1299.00,
                "https://www.newera.mx/cdn/shop/products/unnamed_110c916e-60dc-4ec2-806f-49e0243d7ff2_900x.jpg?v=1667128844"),
            Product(
                14,
                "NFL New England Patriots Training Collection 2023",
                CategoryCaps.NFL,
                true,
                10,
                "Esta gorra New Era 59FIFTY de New England Patriots de la colección NFL Training Collection" +
                        " 2023 presenta el logotipo de los Patriots bordado en los paneles frontales acompañado " +
                        "del nombre del equipo y flag de New Era bordado en el lado izquierdo. Eleva tu estilo a " +
                        "otro nivel y cómprala ya.",
                999.00,
                "https://www.newera.mx/cdn/shop/products/60360566_59FIFTY_NFLTRN23_NEEPAT_OTC_3QL_900x.png?v=1686341044")
        )

        // Función para obtener solo los productos de la categoría NBA
        fun getNBAProducts(): List<Product> {
            return productList.filter { it.category == CategoryCaps.NBA }
        }
        fun getNFLProducts(): List<Product> {
            return productList.filter { it.category == CategoryCaps.NFL }
        }
        fun getMBLProducts(): List<Product> {
            return productList.filter { it.category == CategoryCaps.MBL }
        }
        fun getProduct(idProduct : Int) : Product? {
            return productList.find { it.id == idProduct }
        }
        fun getProductList() : List<Product>{
            return productList.filter { !it.onSale }
        }
        fun getProductsOnSale() : List<Product> {
            return productList.filter { it.onSale }
        }
    }
}