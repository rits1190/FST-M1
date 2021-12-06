#import pandas as pd
#dataframe= pd.read_csv('employees.csv')
#print(dataframe)


	
import pandas
dataframe = pandas.read_excel("employees.xlsx", sheet_name="Sheet1")
print(dataframe)