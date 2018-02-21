#!/bin/sh

echo @startuml
find ./*/ -name build.gradle \
	| while read f
	do
		MODULE=`echo $f | cut -d/ -f2`
		grep 'project' $f | sed 's/.*:\(.*\)'"'"'.*/'$MODULE' <|-- \1/'
	done
echo hide empty members
echo @enduml

