#!/bin/bash

# Configuration
DB_HOST="localhost"      # Adresse de la base de données
DB_PORT="5432"           # Port de PostgreSQL
DB_NAME="crustyz"     # Nom de la base de données
DB_USER="postgres" # Nom d'utilisateur PostgreSQL
DB_PASSWORD="itu16" # Mot de passe de l'utilisateur
SQL_DIR="./database"    # Répertoire contenant les fichiers .sql

# Export du mot de passe pour éviter la saisie interactive
export PGPASSWORD=$DB_PASSWORD

# Vérifier si le répertoire existe
if [ ! -d "$SQL_DIR" ]; then
  echo "Le répertoire $SQL_DIR n'existe pas."
  exit 1
fi

# Parcourir et exécuter chaque fichier .sql
for sql_file in "$SQL_DIR"/*.sql; do
  if [ -f "$sql_file" ]; then
    echo "Exécution de $sql_file ..."
    psql -h $DB_HOST -p $DB_PORT -d $DB_NAME -U $DB_USER -f "$sql_file"
    if [ $? -eq 0 ]; then
      echo "Exécution de $sql_file terminée avec succès."
    else
      echo "Erreur lors de l'exécution de $sql_file."
      exit 1
    fi
  fi
done

echo "Toutes les commandes SQL ont été exécutées."
