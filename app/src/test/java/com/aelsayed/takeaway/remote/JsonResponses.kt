package com.aelsayed.takeaway.remote

val RESTAURANTS = """
{
  "restaurants": [
    {
      "name": "Tanoshii Sushi",
      "status": "open",
      "sortingValues": {
        "bestMatch": 0.0,
        "newest": 96.0,
        "ratingAverage": 4.5,
        "distance": 1190,
        "popularity": 17.0,
        "averageProductPrice": 1536,
        "deliveryCosts": 200,
        "minCost": 1000
      }
    },
    {
      "name": "Tandoori Express",
      "status": "closed",
      "sortingValues": {
        "bestMatch": 1.0,
        "newest": 266.0,
        "ratingAverage": 4.5,
        "distance": 2308,
        "popularity": 123.0,
        "averageProductPrice": 1146,
        "deliveryCosts": 150,
        "minCost": 1300
      }
    },
    {
      "name": "Royal Thai",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 2.0,
        "newest": 133.0,
        "ratingAverage": 4.5,
        "distance": 2639,
        "popularity": 44.0,
        "averageProductPrice": 1492,
        "deliveryCosts": 150,
        "minCost": 2500
      }
    },
    {
      "name": "Sushi One",
      "status": "open",
      "sortingValues": {
        "bestMatch": 3.0,
        "newest": 238.0,
        "ratingAverage": 4.0,
        "distance": 1618,
        "popularity": 23.0,
        "averageProductPrice": 1285,
        "deliveryCosts": 0,
        "minCost": 1200
      }
    },
    {
      "name": "Roti Shop",
      "status": "open",
      "sortingValues": {
        "bestMatch": 4.0,
        "newest": 247.0,
        "ratingAverage": 4.5,
        "distance": 2308,
        "popularity": 81.0,
        "averageProductPrice": 915,
        "deliveryCosts": 0,
        "minCost": 2000
      }
    },
    {
      "name": "Aarti 2",
      "status": "open",
      "sortingValues": {
        "bestMatch": 5.0,
        "newest": 153.0,
        "ratingAverage": 4.5,
        "distance": 1605,
        "popularity": 44.0,
        "averageProductPrice": 922,
        "deliveryCosts": 250,
        "minCost": 500
      }
    },
    {
      "name": "Pizza Heart",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 6.0,
        "newest": 118.0,
        "ratingAverage": 4.0,
        "distance": 2453,
        "popularity": 9.0,
        "averageProductPrice": 1103,
        "deliveryCosts": 150,
        "minCost": 1500
      }
    },
    {
      "name": "Mama Mia",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 7.0,
        "newest": 250.0,
        "ratingAverage": 4.0,
        "distance": 1396,
        "popularity": 6.0,
        "averageProductPrice": 912,
        "deliveryCosts": 0,
        "minCost": 1000
      }
    },
    {
      "name": "Feelfood",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 8.0,
        "newest": 163.0,
        "ratingAverage": 4.5,
        "distance": 2732,
        "popularity": 31.0,
        "averageProductPrice": 902,
        "deliveryCosts": 150,
        "minCost": 1500
      }
    },
    {
      "name": "Daily Sushi",
      "status": "closed",
      "sortingValues": {
        "bestMatch": 9.0,
        "newest": 221.0,
        "ratingAverage": 4.0,
        "distance": 1911,
        "popularity": 6.0,
        "averageProductPrice": 1327,
        "deliveryCosts": 200,
        "minCost": 1000
      }
    },
    {
      "name": "Pamukkale",
      "status": "closed",
      "sortingValues": {
        "bestMatch": 10.0,
        "newest": 201.0,
        "ratingAverage": 4.0,
        "distance": 2353,
        "popularity": 25.0,
        "averageProductPrice": 968,
        "deliveryCosts": 0,
        "minCost": 2000
      }
    },
    {
      "name": "Indian Kitchen",
      "status": "open",
      "sortingValues": {
        "bestMatch": 11.0,
        "newest": 272.0,
        "ratingAverage": 4.5,
        "distance": 2308,
        "popularity": 5.0,
        "averageProductPrice": 1189,
        "deliveryCosts": 150,
        "minCost": 1300
      }
    },
    {
      "name": "CIRO 1939",
      "status": "open",
      "sortingValues": {
        "bestMatch": 12.0,
        "newest": 231.0,
        "ratingAverage": 4.5,
        "distance": 3957,
        "popularity": 79.0,
        "averageProductPrice": 1762,
        "deliveryCosts": 99,
        "minCost": 1300
      }
    },
    {
      "name": "Zenzai Sushi",
      "status": "closed",
      "sortingValues": {
        "bestMatch": 13.0,
        "newest": 155.0,
        "ratingAverage": 4.0,
        "distance": 2911,
        "popularity": 36.0,
        "averageProductPrice": 1579,
        "deliveryCosts": 0,
        "minCost": 2000
      }
    },
    {
      "name": "Fes Patisserie",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 14.0,
        "newest": 77.0,
        "ratingAverage": 4.0,
        "distance": 2302,
        "popularity": 3.0,
        "averageProductPrice": 1214,
        "deliveryCosts": 150,
        "minCost": 1250
      }
    },
    {
      "name": "Yvonne's Vispaleis",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 15.0,
        "newest": 150.0,
        "ratingAverage": 5.0,
        "distance": 2909,
        "popularity": 3.0,
        "averageProductPrice": 2557,
        "deliveryCosts": 150,
        "minCost": 1750
      }
    },
    {
      "name": "De Amsterdamsche Tram",
      "status": "open",
      "sortingValues": {
        "bestMatch": 304.0,
        "newest": 131.0,
        "ratingAverage": 0.0,
        "distance": 2792,
        "popularity": 0.0,
        "averageProductPrice": 892,
        "deliveryCosts": 0,
        "minCost": 0
      }
    },
    {
      "name": "Lale Restaurant & Snackbar",
      "status": "order ahead",
      "sortingValues": {
        "bestMatch": 305.0,
        "newest": 73.0,
        "ratingAverage": 0.0,
        "distance": 2880,
        "popularity": 0.0,
        "averageProductPrice": 838,
        "deliveryCosts": 0,
        "minCost": 0
      }
    },
    {
      "name": "Lunchpakketdienst",
      "status": "open",
      "sortingValues": {
        "bestMatch": 306.0,
        "newest": 259.0,
        "ratingAverage": 3.5,
        "distance": 14201,
        "popularity": 0.0,
        "averageProductPrice": 4465,
        "deliveryCosts": 500,
        "minCost": 5000
      }
    }
  ]
}
""".trimIndent()


val NO_RESULT = """
  {
    "status": "error",
    "message": "No Result"
  }
""".trimIndent()
