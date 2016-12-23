# casablanca-bourse-api
# Documentation

**Get Companie**
----
  Returns json data about a single companie.

* **URL**

  /api/v1/companies/:name

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `name=[string]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"name":"COSUMAR","status":"T","referencePrice":305.0,"open":307.3,"lastPrice":324.95,"numberOfSharesTraded":83189,"volume":2.664651285E7,"change":6.54,"intradayHigh":324.95,"intradayLow":307.2}`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Companie doesn't exist" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/api/v1/companies/COSUMAR",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```

**Get Companies**
----
  Returns json data about all the companies.

* **URL**

  /api/v1/companies/

* **Method:**

  `GET`
  
*  **URL Params**

  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{"name":"COSUMAR","status":"T","referencePrice":305.0,"open":307.3,"lastPrice":324.95,"numberOfSharesTraded":83189,"volume":2.664651285E7,"change":6.54,"intradayHigh":324.95,"intradayLow":307.2}`<br />
    `...`<br /> `{"name":"TIMAR","status":"N.T","referencePrice":313.0,"open":null,"lastPrice":313.0,"numberOfSharesTraded":0,"volume":null,"change":0.0,"intradayHigh":null,"intradayLow":null}]`
    
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Empty ressource" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/api/v1/companies/",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```
