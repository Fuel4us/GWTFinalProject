﻿Devido ao método de serialização do CSheets(serialização built-in do java), abrir no CSheets um ficheiro CLS exportado do WSheets(ou vice-versa) não é possível, pois os nomes das packages são diferentes, o que resulta numa ClassCastException.