	ORG	600H ; Variables
var DB 0h
	ORG 2000H ; Programa Principal
	MOV AX , 25h
	MOV BX , 37h
	ADD AX , BX
	MOV var , AX
	END
	