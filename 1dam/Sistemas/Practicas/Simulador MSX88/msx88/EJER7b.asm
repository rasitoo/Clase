	ORG	500H ; Variables
var1 DB 10h
var2 DB 11h
res DB 0h
	ORG 2000H ; Programa Principal
	MOV AL , var1
	MOV BL , var2
	ADD AL , BL
	MOV res , AL
	END
	