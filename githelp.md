# Git help
Documentación de ayuda para la organización del repositorio y entregas.

## Entorno de desarrollo
* **IDE / Editor de texto** 

    Creo que la gran mayoría utiliza [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) ya que con el mail de FIUBA se tiene una licencia. Otra opción es utilizar [Atom](https://atom.io/) o [VSCode](https://code.visualstudio.com/), descargando los *plug-in* necesarios para poder trabajar de forma cómoda con java. 

* **GIT (IDE)**
En esta sección dejo el link para descargar [GIT](https://git-scm.com/download/win). Git se puede usar con cómandos como los vimos en clase, pero tal vez lo mejor en una primera experiencia esta bueno contar con una interfaz gráfica. Dejo dos opciones, la priemera es la la propia que tiene [GitHub](https://desktop.github.com/) y una segunda opción [Sourcetree](https://www.sourcetreeapp.com/). Lo positivo que tiene *sourcetree* es que te muestra gráficamente las ramas en un formato muy fácil de comprender. De todas formas se puede usar cualquier otro IDE o línea de comandos.


## Git Workflow
### Git branching model
Para un trabajo colvarativo propongo utilizar el propuesto por  Vincent Driessen en [a successful git branching model](https://nvie.com/posts/a-successful-git-branching-model/). De esta manera creo que lo mejor es tener dos ramas paralelas:

* **master**   
    Contiene la última versión estable.  
    Cuando se realiza una release taguear de la siguiente forma
    ```
    git tag -a VA.B.C -m “Comentario opcional”
    ```  
    _Cómo taguear:_
    - **A.x.x**, Major version ---> cambios incompatibles.  
    - **x.B.x**, Minor version ---> Nuevas mejoras.  
    - **x.x.C**, Patch version ---> Arreglos de bugs

La idea sería hacer una release por cada entrega que tengas que hacer.

* **develop**  
    En esta rama se agregan cambios incrementales, bugs o mejoras, hasta que se considera que es el momento de hacer una release nueva o que haya que hacer una entrega.  
    Antes de hacer la release comprobar el funcionamiento integral de  la aplicación. Lo importante es que en cada release quede código funcionando.

* **issue**  
    En estas ramas se implementan mejoras o correcciones de bugs.  Estas ramas nacen de **develop**
    El flujo es el siguiente:  
    1. Se agrega una [issue acá](https://github.com/fvazquezf/TP_2_Algo_3/issues), donde se describe el tipo ~Bug o ~Mejora:   
        - Si es ~Mejora, breve descripción, qué es lo que se espera que modifique, posible forma de implementación, etc.
        - Si es ~Bug, describirlo, explicar los pasos para reproducirlo, cuál es el funcionamiento esperado y cuál es el que sucede.
    2. Asignar la issue a la persona encargada de resolverla.
    3. Asignar etiqueta ~Doing cuando se comience a desarrollar.
    4. Crear una rama desde develop para implementarla:
	    * La nomenclatura propuesta es la siguiente:
		    * feature/< TagFeature >: Para nombrar una mejora
		    * bugfix/< TagBug>: Para un bug a solucionar
    
        ```    
        $ git checkout develop  
        $ git checkout -b featrue/xx
        ```
        > En el ejemplo se realizó una rama para una mejora.
        
    5. Una vez testeada realizar un [Pull Request](https://github.com/pulls) a **develop** para que alquien del equipo pueda corroborar los cambios. Luego se puede eliminar la rama. 
    
    > NOTA: 
    Con `$ git -d issue_xx` se elimina la rama localmente, en caso de que se haya pusheado dicha rama a origin (repo en la nube) eliminarla de allí también mediante  `$ git push origin --delete the_remote_branch`  
    6. Una vez finalizada la mejora o arreglado el bug dar por cerrado el issue.
