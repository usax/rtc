cd avatarwsdls
x=$(find . -name pom.xml);

echo $x
for item in $x
do
echo hello $item

cat $item
done
