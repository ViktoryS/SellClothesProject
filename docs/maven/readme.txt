How you can confugure maven tomcat plugin in ClothesProject:
1. Move tomcat-users.xml file to %tomcat-home%\conf from this folder.
2. Move settings.xml file to %users%\.m2 from this folder.
3. Add tomcat plugin and some settings to pom.xml file like this:

		 <build>
				<plugins>
					<plugin>
						<groupId>org.apache.tomcat.maven</groupId>
						<artifactId>tomcat7-maven-plugin</artifactId>
						<version>2.2</version>
						<configuration>
							<url>http://localhost:8080/manager/text</url>
							<server>TomcatServer</server>
							<path>/SellClothesProject</path>
							<username>tomcat</username>
							<password>s3cret</password>
						</configuration>
					</plugin>
				</plugins>
			</build>
			
When you have done all this items, you could run this project. ;)))

*Don't forget, that tomcat and maven have already instaled on your computer