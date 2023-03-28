## Hace todos los puntos pedidos (40%)

#### Permite crear usuarios vía endpoint

OK

#### Permite añadir favoritos vía endpoint

OK

#### Si el pokemon ya está marcado como favorito, ¿se lanza una excepción de dominio?

OK

#### Si el usuario no existe, ¿se lanza una excepción de dominio?

OK

#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP?

OK

#### Hay tests unitarios

##### Capa aplicación

KO

##### Capa dominio

OK

**Puntuación: 35/40**

## Se aplican conceptos explicados (40%)

#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)

OK

#### Aggregates + VOs

OK

#### No se trabajan con tipos primitivos en dominio

OK

#### Hay use cases en aplicación reutilizables

OK

#### Se aplica el patrón repositorio

OK

#### Se utilizan object mothers

KO

**Puntuación: 35/40**

## Facilidad setup + README (20%)

#### El README contiene al menos los apartados "cómo ejecutar la aplicación", "cómo usar la aplicación"

KO, no incluye la documentación de los nuevos endpoints ni cómo lanzar los tests

#### Es sencillo seguir el apartado "cómo ejecutar la aplicación"

OK

**Puntuación: 11/20**

## Extra

- Un endpoint para eliminar los pokemons favoritos

**Puntuación: +5**

## Observaciones

- Tenéis que mejorar las URLs de vuestros endpoints.
    - Usad
      el [estándar](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Why-you-should-make-kebab-case-a-URL-naming-convention-best-practice)
      de escritura de URLs (kebab case)
    - Intentad usar los "REST principles"
        - Cuando creáis un recurso, tenéis que usar un `POST`, no un `GET`
        - Cuando modificáis un recurso o hacéis algún cambio podéis usar un `PUT` o un `PATCH`, tampoco un `GET`
        - Cuando accedéis a alguna operación de algún recurso, no debe ser `GET url/create-trainer`
          o `GET AddFavouritePokemonToTrainer/1` sino que debería
          ser `POST url/trainer` y `PATCH url/trainer/favorite-pokemon/1` o similar
        - Cuando no se encuentra un recurso o no se puede crear un recurso ya creado, deberían ser códigos de error
          como `404 NOT FOUND` o `409 CONFLICT`. No `400 BAD REQUEST`

**Puntuación:  -5**

**PUNTUACIÓN FINAL: 81/100**
