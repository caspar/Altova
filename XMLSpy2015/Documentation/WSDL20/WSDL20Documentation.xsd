<?xml version="1.0" encoding="UTF-8"?>
<!-- edited with XMLSpy v2013 (http://www.altova.com) by Mr. Nobody (Altova GmbH) -->
<xs:schema xmlns="http://www.altova.com/documentation" xmlns:xs="http://www.w3.org/2001/XMLSchema" targetNamespace="http://www.altova.com/documentation" elementFormDefault="qualified" attributeFormDefault="unqualified">
	<xs:include schemaLocation="../Schema/SchemaDocumentation.xsd"/>
	<xs:element name="WSDL20Documentation">
		<xs:annotation>
			<xs:documentation>Root element of the WSDL 2.0 documentation</xs:documentation>
		</xs:annotation>
		<xs:complexType>
			<xs:sequence>
				<xs:element ref="Document"/>
				<xs:element name="DocumentationSettings">
					<xs:complexType>
						<xs:sequence>
							<xs:element name="Includes">
								<xs:complexType>
									<xs:attribute name="overview" type="xs:boolean" use="required"/>
									<xs:attribute name="referencedFiles" type="xs:boolean" use="required"/>
									<xs:attribute name="types" type="xs:boolean" use="required"/>
									<xs:attribute name="service" type="xs:boolean" use="required"/>
									<xs:attribute name="binding" type="xs:boolean" use="required"/>
									<xs:attribute name="interface" type="xs:boolean" use="required"/>
								</xs:complexType>
							</xs:element>
							<xs:element name="Details">
								<xs:complexType>
									<xs:attribute name="typesDiagram" type="xs:boolean" use="required"/>
									<xs:attribute name="serviceDiagram" type="xs:boolean" use="required"/>
									<xs:attribute name="bindingDiagram" type="xs:boolean" use="required"/>
									<xs:attribute name="interfaceDiagram" type="xs:boolean" use="required"/>
									<xs:attribute name="endpoints" type="xs:boolean" use="required"/>
									<xs:attribute name="sourceCode" type="xs:boolean" use="required"/>
									<xs:attribute name="extensibilities" type="xs:boolean" use="required"/>
									<xs:attribute name="usedBy" type="xs:boolean" use="required"/>
									<xs:attribute name="operations" type="xs:boolean" use="required"/>
									<xs:attribute name="faults" type="xs:boolean" use="required"/>
								</xs:complexType>
							</xs:element>
						</xs:sequence>
					</xs:complexType>
				</xs:element>
				<xs:element name="WSDLDocument">
					<xs:complexType>
						<xs:attribute name="wsdlLocation" type="xs:anyURI" use="required"/>
						<xs:attribute name="href" type="xs:anyURI" use="required"/>
						<xs:attribute name="targetNamespace" type="xs:string" use="required"/>
					</xs:complexType>
				</xs:element>
				<xs:choice minOccurs="0" maxOccurs="unbounded">
					<xs:element ref="Service"/>
					<xs:element ref="Binding"/>
					<xs:element ref="Interface"/>
					<xs:element ref="SchemaDocument"/>
				</xs:choice>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	<xs:element name="Documentations">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="Documentation" type="xs:string" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	<xs:element name="ImportedFrom" type="xs:string"/>
	<xs:element name="Service">
		<xs:complexType mixed="true">
			<xs:complexContent>
				<xs:extension base="TNamedItem">
					<xs:sequence>
						<xs:element ref="Documentations" minOccurs="0"/>
						<xs:element ref="Diagram" minOccurs="0"/>
						<xs:element ref="ImportedFrom" minOccurs="0"/>
						<xs:element name="Endpoints" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Endpoint" minOccurs="0" maxOccurs="unbounded">
										<xs:complexType mixed="true">
											<xs:complexContent>
												<xs:extension base="TNamedItem">
													<xs:sequence>
														<xs:element ref="Documentations" minOccurs="0"/>
														<xs:element name="Binding" type="TText" minOccurs="0"/>
														<xs:element name="Address" type="xs:string" minOccurs="0"/>
														<xs:element name="Attributes" minOccurs="0">
															<xs:complexType>
																<xs:sequence>
																	<xs:element name="Attribute" type="TNamedText" minOccurs="0" maxOccurs="unbounded"/>
																</xs:sequence>
															</xs:complexType>
														</xs:element>
													</xs:sequence>
												</xs:extension>
											</xs:complexContent>
										</xs:complexType>
									</xs:element>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element ref="Source" minOccurs="0"/>
					</xs:sequence>
					<xs:attribute name="newFile" type="xs:anyURI"/>
				</xs:extension>
			</xs:complexContent>
		</xs:complexType>
	</xs:element>
	<xs:element name="Binding">
		<xs:complexType mixed="true">
			<xs:complexContent>
				<xs:extension base="TNamedItem">
					<xs:sequence>
						<xs:element ref="Documentations" minOccurs="0"/>
						<xs:element ref="Diagram" minOccurs="0"/>
						<xs:element ref="ImportedFrom" minOccurs="0"/>
						<xs:element name="Type" type="xs:string" minOccurs="0"/>
						<xs:element name="Interface" type="TText" minOccurs="0"/>
						<xs:element name="Extensibility" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element ref="Attributes" minOccurs="0"/>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element name="Operations" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Operation" minOccurs="0" maxOccurs="unbounded">
										<xs:complexType mixed="true">
											<xs:complexContent>
												<xs:extension base="TNamedRef">
													<xs:sequence>
														<xs:element ref="Documentations" minOccurs="0"/>
														<xs:element ref="Attributes" minOccurs="0"/>
														<xs:element ref="SoapModules" minOccurs="0"/>
														<xs:element name="References" minOccurs="0">
															<xs:complexType>
																<xs:choice minOccurs="0" maxOccurs="unbounded">
																	<xs:element name="Input" minOccurs="1">
																		<xs:complexType>
																			<xs:complexContent>
																				<xs:extension base="TNamedRef">
																					<xs:sequence>
																						<xs:element ref="Documentations" minOccurs="0"/>
																						<xs:element ref="Attributes" minOccurs="0"/>
																						<xs:element ref="SoapModules" minOccurs="0"/>
																						<xs:element ref="SoapHeaders" minOccurs="0"/>
																						<xs:element ref="HttpHeaders" minOccurs="0"/>
																					</xs:sequence>
																				</xs:extension>
																			</xs:complexContent>
																		</xs:complexType>
																	</xs:element>
																	<xs:element name="Output" minOccurs="1">
																		<xs:complexType>
																			<xs:complexContent>
																				<xs:extension base="TNamedRef">
																					<xs:sequence>
																						<xs:element ref="Documentations" minOccurs="0"/>
																						<xs:element ref="Attributes" minOccurs="0"/>
																						<xs:element ref="SoapModules" minOccurs="0"/>
																						<xs:element ref="SoapHeaders" minOccurs="0"/>
																						<xs:element ref="HttpHeaders" minOccurs="0"/>
																					</xs:sequence>
																				</xs:extension>
																			</xs:complexContent>
																		</xs:complexType>
																	</xs:element>
																	<xs:element name="Infault" minOccurs="1">
																		<xs:complexType>
																			<xs:complexContent>
																				<xs:extension base="TNamedRef">
																					<xs:sequence>
																						<xs:element name="InterfaceFault" type="TText" minOccurs="0"/>
																						<xs:element ref="Documentations" minOccurs="0"/>
																						<xs:element ref="SoapModules" minOccurs="0"/>
																					</xs:sequence>
																				</xs:extension>
																			</xs:complexContent>
																		</xs:complexType>
																	</xs:element>
																	<xs:element name="Outfault" minOccurs="1">
																		<xs:complexType>
																			<xs:complexContent>
																				<xs:extension base="TNamedRef">
																					<xs:sequence>
																						<xs:element name="InterfaceFault" type="TText" minOccurs="0"/>
																						<xs:element ref="Documentations" minOccurs="0"/>
																						<xs:element ref="SoapModules" minOccurs="0"/>
																					</xs:sequence>
																				</xs:extension>
																			</xs:complexContent>
																		</xs:complexType>
																	</xs:element>
																</xs:choice>
															</xs:complexType>
														</xs:element>
													</xs:sequence>
												</xs:extension>
											</xs:complexContent>
										</xs:complexType>
									</xs:element>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element name="Faults" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Fault" minOccurs="0" maxOccurs="unbounded">
										<xs:complexType>
											<xs:complexContent>
												<xs:extension base="TNamedRef">
													<xs:sequence>
														<xs:element ref="Attributes" minOccurs="0"/>
														<xs:element ref="SoapModules" minOccurs="0"/>
														<xs:element ref="SoapHeaders" minOccurs="0"/>
														<xs:element ref="HttpHeaders" minOccurs="0"/>
													</xs:sequence>
												</xs:extension>
											</xs:complexContent>
										</xs:complexType>
									</xs:element>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element name="UsedBy" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="By" minOccurs="0" maxOccurs="unbounded">
										<xs:complexType>
											<xs:sequence>
												<xs:element name="Endpoint" type="TText"/>
												<xs:element name="Service" type="TText"/>
											</xs:sequence>
										</xs:complexType>
									</xs:element>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element ref="Source" minOccurs="0"/>
					</xs:sequence>
					<xs:attribute name="newFile" type="xs:anyURI"/>
				</xs:extension>
			</xs:complexContent>
		</xs:complexType>
	</xs:element>
	<xs:element name="Interface">
		<xs:complexType mixed="true">
			<xs:complexContent>
				<xs:extension base="TNamedItem">
					<xs:sequence>
						<xs:element ref="Documentations" minOccurs="0"/>
						<xs:element ref="Diagram" minOccurs="0"/>
						<xs:element ref="ImportedFrom" minOccurs="0"/>
						<xs:element name="Extends" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Interface" type="TText" maxOccurs="unbounded"/>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element name="StyleDefault" type="TText" minOccurs="0"/>
						<xs:element name="Operations" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Operation" minOccurs="0" maxOccurs="unbounded">
										<xs:complexType mixed="true">
											<xs:complexContent>
												<xs:extension base="TNamedItem">
													<xs:sequence>
														<xs:element ref="Documentations" minOccurs="0"/>
														<xs:element name="Pattern" type="TText"/>
														<xs:element name="Style" type="TText" minOccurs="0"/>
														<xs:element name="References" minOccurs="0">
															<xs:complexType>
																<xs:choice minOccurs="0" maxOccurs="unbounded">
																	<xs:element name="Input" type="TInterfaceReference"/>
																	<xs:element name="Output" type="TInterfaceReference"/>
																	<xs:element name="Infault" type="TInterfaceReference"/>
																	<xs:element name="Outfault" type="TInterfaceReference"/>
																</xs:choice>
															</xs:complexType>
														</xs:element>
													</xs:sequence>
												</xs:extension>
											</xs:complexContent>
										</xs:complexType>
									</xs:element>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element name="Faults" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Fault" minOccurs="0" maxOccurs="unbounded">
										<xs:complexType mixed="true">
											<xs:complexContent>
												<xs:extension base="TNamedItem">
													<xs:sequence>
														<xs:element ref="Documentations" minOccurs="0"/>
														<xs:element name="Element" type="TText"/>
													</xs:sequence>
												</xs:extension>
											</xs:complexContent>
										</xs:complexType>
									</xs:element>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element name="UsedBy" minOccurs="0">
							<xs:complexType>
								<xs:sequence>
									<xs:element name="Interface" type="TText" minOccurs="0" maxOccurs="unbounded"/>
									<xs:element name="Binding" type="TText" minOccurs="0" maxOccurs="unbounded"/>
									<xs:element name="Service" type="TText" minOccurs="0" maxOccurs="unbounded"/>
								</xs:sequence>
							</xs:complexType>
						</xs:element>
						<xs:element ref="Source" minOccurs="0"/>
					</xs:sequence>
					<xs:attribute name="newFile" type="xs:anyURI"/>
				</xs:extension>
			</xs:complexContent>
		</xs:complexType>
	</xs:element>
	<xs:element name="Attributes">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="Attribute" type="TNamedItem" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	<xs:element name="SoapModules">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="SoapModule" type="TSource" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
			<xs:attribute name="name" type="xs:string" use="required"/>
		</xs:complexType>
	</xs:element>
	<xs:element name="SoapHeaders">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="SoapHeader" type="TSource" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
			<xs:attribute name="name" type="xs:string" use="required"/>
		</xs:complexType>
	</xs:element>
	<xs:element name="HttpHeaders">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="HttpHeader" type="TSource" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
			<xs:attribute name="name" type="xs:string" use="required"/>
		</xs:complexType>
	</xs:element>
	<xs:complexType name="TInterfaceReference">
		<xs:sequence>
			<xs:element name="Element" type="TText" minOccurs="0"/>
			<xs:element ref="Documentations" minOccurs="0"/>
		</xs:sequence>
		<xs:attribute name="name" type="xs:string" use="required"/>
	</xs:complexType>
</xs:schema>
