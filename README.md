**1 Fonctionnalité pricipale**

Ce code permet la gestion de locations de films

**2 Règles métiers**

>Données
 - Un film est constitué d'un titre et d'un code de prix
 - Le code de prix peut avoir pour valeur 0 (Normal), 1 (Nouveauté) et 2 (Enfant)

 - Une location est constitué d'un Film et du nombre de jours de la location
 - Un Client est constitué d'une liste de locations et d'un nom

 - On veut pouvoir afficher la situation du client (nom, montant dû et points de fidélité)

>Montant dû
>>Code prix : Normal
>  - Si le nombre de jours <= 2, alors le montant dû de la location est de 2
>  - Sinon, il est de 2 + (nombre de jours - 2) * 1.5
>>Code prix : Nouveauté
>  - Nombre de jours * 3
>> Code prix : Enfant
>  - Si le nombre de jours <= 3, alors le montant dû de la location est de 1.5
>  - Sinon, il est de 3 + (nombre de jours - 3) * 1.5


>Points de fidélités
>> - Un point de fidélité est obtenu pour chaque location de film
> - Un point bonus est attribué pour les nouveautées louées au moins deux jours