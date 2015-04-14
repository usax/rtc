. /home/umashankar/logging.properties

echo $username
echo $password
echo $service_name

conn=$username$password$service_name

IFS=', ' read -a array <<< "$service_name"

for element in "${array[@]}"
do
    echo "$element"
done

for index in "${!array[@]}"
do
    echo "$index ${array[index]}"
done

