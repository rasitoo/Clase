	ORG	1999H ; Variables
var1 DB 1h
var2 DB 5h
ORG 2000H ; Programa Principal
MOV BL, var2
ADD BL, var1
ADD BL, var1
ADD BL, var1
ADD BL, var1
	END
	