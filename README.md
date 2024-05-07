# Statement parser

## H2
http://localhost:8080/h2-console

## Parse a Skandia statement
curl -X POST -F "file=@/Users/tomfaa/git/statement-parser-core/src/test/resources/SKANDIA_91526019577_2024-03-01-2024-03-31.xlsx" http://localhost:8080/statement-parser?type=SKANDIA
