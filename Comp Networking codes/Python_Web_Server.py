
__author__ = 'Rohan'
from socket import *

def main():
    #declaring the port’s value
    serverport=8080
	
    serSocket=socket(AF_INET,SOCK_STREAM)
	
    #Binding the server port to the server ip address
	serSocket.bind(('',serverport))
	
	#setting the server on a listen mode for one single client
	serSocket.listen(1)
  
  while True:
    print 'Web Server is Ready to serve'
    connectionSocket, addr=serSocket.accept()
    
	
	try:
      message=connectionSocket.recv(1000)
      print ("message,'::',message.split()[0],'::',message.split()[1]")
      
	  filename=message.split()[1]
      print ('THE FILE REQUESTED TO OPEN IS :',filename[1:],'\n')
      
	  f=open(filename[1:])
      outputdata=f.read()
      print outputdata
      
	  #The result for successful transmission of html file
	  connectionSocket.send('\nHTTP/1.1 200 OK\n\n') 
      connectionSocket.send(outputdata)
      connectionSocket.close()
    except IOError:
      print 'THE PAGE NOT FOUND\n404 ERROR \nNOT FOUND'
      connectionSocket.send('\n404 File Not Found\n\n') #This is the result of error in case of file not found
    
    break
  pass
if __name__=='__main__':
    main()
