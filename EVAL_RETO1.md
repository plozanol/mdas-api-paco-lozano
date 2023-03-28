## Hace todos los puntos pedidos (40%)

#### Dado un nombre vía argumento, devolver sus tipos

OK

#### Dado un nombre vía endpoint, devolver sus tipos

OK

#### Si no existe el pokemon, ¿se lanza una excepción de dominio?

OK

#### Si la api da timeout, ¿se lanza una excepción de dominio?

OK

#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP/un error legible en consola?

OK

**Puntuación: 40/40**

## Se aplican conceptos explicados (40%)

#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)

OK

#### Aggregates + VOs

- Existe un VO `PokemonName` que no está en el agregado. Únicamente se está utilizando para hacer la búsqueda en el
  repositorio pero no pertenece a ningún agregado, ¿cómo es posible buscar por un VO que no pertenece a ningún agregado?

#### No se trabajan con tipos primitivos en dominio

OK

#### Hay use cases en aplicación reutilizables

OK

#### Se aplica el patrón repositorio

OK

**Puntuación: 35/40**

## Facilidad setup + README (20%)

#### El README contiene al menos los apartados ""cómo ejecutar la aplicación"", ""cómo usar la aplicación""

OK, aunque falta indicar que como pre-requisito también hay que tener maven instalado. Una buena idea habría sido hacer
un Dockerfile y así no tendría que instalar nada :-P

#### Es sencillo seguir el apartado ""cómo ejecutar la aplicación""

OK

**Puntuación: 15/20**

## Extra

- Commits en "baby steps". Pequeños y legibles. Aunque veo algunos como `Update Readme.md` triplicados
  o `update of maven build properties and update of readme`. Siendo varios commits iguales quizá es mejor hacer un amend
  del primer commit que actualice el readme las veces necesarias para que nos facilite la lectura de la historia de git;
  o bien un squash de varios commits similares que no aportan demasiada información
- Usad
  el [estándar](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Why-you-should-make-kebab-case-a-URL-naming-convention-best-practice)
  de escritura de URLs (kebab case). Ej: `/pokemon-type` o `/type` pasándole el `name` como un query param

**Puntuación: +3**

**PUNTUACIÓN FINAL: 93/100**
