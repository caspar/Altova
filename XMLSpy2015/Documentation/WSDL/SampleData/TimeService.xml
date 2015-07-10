<WSDLDocumentation xmlns="http://www.altova.com/documentation" xmlns:doc="http://www.altova.com/documentation">
	<Document title="TimeService.wsdl" application="XMLSpy" homepage="http://www.altova.com/xmlspy"/>
	<DocumentationSettings>
		<Includes overview="true" referencedFiles="true" types="true" service="true" binding="true" portType="true" messages="true"/>
		<Details typesDiagram="true" serviceDiagram="true" bindingDiagram="true" portTypeDiagram="true" messageParts="true" sourceCode="true" extensibilities="true" usedBy="true" port="true" portTypeOperations="true"/>
	</DocumentationSettings>
	<WSDLDocument wsdlLocation="TimeService.wsdl" href="TimeService.wsdl" targetNamespace="http://www.Nanonull.com/TimeService/"/>
	<Service id="Link11" name="TimeService">
		<Documentations>
			<Documentation>A sample Time service</Documentation>
		</Documentations>
		<Diagram src="TimeService_diagrams/TimeService_p1.png" width="355" height="148"/>
		<Ports>
			<Port id="Link12" name="TimeServiceSoap">
				<Binding ref="Link13">s0:TimeServiceSoap</Binding>
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:address location="http://www.nanonull.com/TimeService/TimeService.asmx"/>
				</Extensibility>
			</Port>
			<Port id="Link14" name="TimeServiceHttpGet">
				<Binding ref="Link15">s0:TimeServiceHttpGet</Binding>
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:address location="http://www.nanonull.com/TimeService/TimeService.asmx"/>
				</Extensibility>
			</Port>
			<Port id="Link16" name="TimeServiceHttpPost">
				<Binding ref="Link17">s0:TimeServiceHttpPost</Binding>
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:address location="http://www.nanonull.com/TimeService/TimeService.asmx"/>
				</Extensibility>
			</Port>
		</Ports>
		<Source xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
			<service name="TimeService">
				<documentation>A sample Time service</documentation>
				<port name="TimeServiceSoap" binding="s0:TimeServiceSoap">
					<soap:address location="http://www.nanonull.com/TimeService/TimeService.asmx"/>
				</port>
				<port name="TimeServiceHttpGet" binding="s0:TimeServiceHttpGet">
					<http:address location="http://www.nanonull.com/TimeService/TimeService.asmx"/>
				</port>
				<port name="TimeServiceHttpPost" binding="s0:TimeServiceHttpPost">
					<http:address location="http://www.nanonull.com/TimeService/TimeService.asmx"/>
				</port>
			</service>
		</Source>
	</Service>
	<Binding id="Link15" name="TimeServiceHttpGet">
		<Diagram src="TimeService_diagrams/TimeService_p2.png" width="216" height="1045"/>
		<Type ref="Link18">s0:TimeServiceHttpGet</Type>
		<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
			<http:binding verb="GET"/>
		</Extensibility>
		<Operations>
			<Operation name="getUTCTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getUTCTime"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getOffesetUTCTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getOffesetUTCTime"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getServerTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getServerTime"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getServerTimeZone">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getServerTimeZone"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getServerCity">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getServerCity"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getTimeZoneTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getTimeZoneTime"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getCityTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getCityTime"/>
				</Extensibility>
				<Input xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:urlEncoded/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
		</Operations>
		<UsedBy>
			<By>
				<Port ref="Link14">TimeServiceHttpGet</Port>
				<Service ref="Link11">TimeService</Service>
			</By>
		</UsedBy>
		<Source xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
			<binding name="TimeServiceHttpGet" type="s0:TimeServiceHttpGet">
				<http:binding verb="GET"/>
				<operation name="getUTCTime">
					<http:operation location="/getUTCTime"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getOffesetUTCTime">
					<http:operation location="/getOffesetUTCTime"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getServerTime">
					<http:operation location="/getServerTime"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getServerTimeZone">
					<http:operation location="/getServerTimeZone"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getServerCity">
					<http:operation location="/getServerCity"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getTimeZoneTime">
					<http:operation location="/getTimeZoneTime"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
					<fault name="FaultTimeZoneNotFound">
						<mime:mimeXml part="Error"/>
					</fault>
				</operation>
				<operation name="getCityTime">
					<http:operation location="/getCityTime"/>
					<input>
						<http:urlEncoded/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
					<fault name="FaultCityNotFound">
						<mime:mimeXml part="Error"/>
					</fault>
				</operation>
			</binding>
		</Source>
	</Binding>
	<Binding id="Link17" name="TimeServiceHttpPost">
		<Diagram src="TimeService_diagrams/TimeService_p3.png" width="279" height="1157"/>
		<Type ref="Link19">s0:TimeServiceHttpPost</Type>
		<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
			<http:binding verb="POST"/>
		</Extensibility>
		<Operations>
			<Operation name="getUTCTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getUTCTime"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getOffesetUTCTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getOffesetUTCTime"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getServerTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getServerTime"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getServerTimeZone">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getServerTimeZone"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getServerCity">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getServerCity"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getTimeZoneTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getTimeZoneTime"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
			<Operation name="getCityTime">
				<Extensibility xmlns:http="http://schemas.xmlsoap.org/wsdl/http/">
					<http:operation location="/getCityTime"/>
				</Extensibility>
				<Input xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:content type="application/x-www-form-urlencoded"/>
				</Input>
				<Output xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
					<mime:mimeXml part="Body"/>
				</Output>
			</Operation>
		</Operations>
		<UsedBy>
			<By>
				<Port ref="Link16">TimeServiceHttpPost</Port>
				<Service ref="Link11">TimeService</Service>
			</By>
		</UsedBy>
		<Source xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/">
			<binding name="TimeServiceHttpPost" type="s0:TimeServiceHttpPost">
				<http:binding verb="POST"/>
				<operation name="getUTCTime">
					<http:operation location="/getUTCTime"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getOffesetUTCTime">
					<http:operation location="/getOffesetUTCTime"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getServerTime">
					<http:operation location="/getServerTime"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getServerTimeZone">
					<http:operation location="/getServerTimeZone"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getServerCity">
					<http:operation location="/getServerCity"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
				</operation>
				<operation name="getTimeZoneTime">
					<http:operation location="/getTimeZoneTime"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
					<fault name="FaultTimeZoneNotFound">
						<mime:mimeXml part="Error"/>
					</fault>
				</operation>
				<operation name="getCityTime">
					<http:operation location="/getCityTime"/>
					<input>
						<mime:content type="application/x-www-form-urlencoded"/>
					</input>
					<output>
						<mime:mimeXml part="Body"/>
					</output>
					<fault name="FaultCityNotFound">
						<mime:mimeXml part="Error"/>
					</fault>
				</operation>
			</binding>
		</Source>
	</Binding>
	<Binding id="Link13" name="TimeServiceSoap">
		<Diagram src="TimeService_diagrams/TimeService_p4.png" width="381" height="914"/>
		<Type ref="Link1A">s0:TimeServiceSoap</Type>
		<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
			<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
		</Extensibility>
		<Operations>
			<Operation name="getUTCTime">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getUTCTime" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
			<Operation name="getOffesetUTCTime">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getOffesetUTCTime" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
			<Operation name="getServerTime">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getServerTime" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
			<Operation name="getServerTimeZone">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getServerTimeZone" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
			<Operation name="getServerCity">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getServerCity" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
			<Operation name="getTimeZoneTime">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getTimeZoneTime" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
			<Operation name="getCityTime">
				<Extensibility xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getCityTime" style="document"/>
				</Extensibility>
				<Input xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Input>
				<Output xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
					<soap:body use="literal"/>
				</Output>
			</Operation>
		</Operations>
		<UsedBy>
			<By>
				<Port ref="Link12">TimeServiceSoap</Port>
				<Service ref="Link11">TimeService</Service>
			</By>
		</UsedBy>
		<Source xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
			<binding name="TimeServiceSoap" type="s0:TimeServiceSoap">
				<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
				<operation name="getUTCTime">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getUTCTime" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
				</operation>
				<operation name="getOffesetUTCTime">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getOffesetUTCTime" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
				</operation>
				<operation name="getServerTime">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getServerTime" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
				</operation>
				<operation name="getServerTimeZone">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getServerTimeZone" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
				</operation>
				<operation name="getServerCity">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getServerCity" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
				</operation>
				<operation name="getTimeZoneTime">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getTimeZoneTime" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
					<fault name="FaultTimeZoneNotFound">
						<soap:fault name="FaultTimeZoneNotFound" use="literal"/>
					</fault>
				</operation>
				<operation name="getCityTime">
					<soap:operation soapAction="http://www.Nanonull.com/TimeService/getCityTime" style="document"/>
					<input>
						<soap:body use="literal"/>
					</input>
					<output>
						<soap:body use="literal"/>
					</output>
					<fault name="FaultCityNotFound">
						<soap:fault name="FaultCityNotFound" use="literal"/>
					</fault>
				</operation>
			</binding>
		</Source>
	</Binding>
	<PortType id="Link18" name="TimeServiceHttpGet">
		<Diagram src="TimeService_diagrams/TimeService_p5.png" width="277" height="738"/>
		<Operations>
			<Operation id="Link1B" name="getUTCTime">
				<Messages>
					<Message type="input" name="s0:getUTCTimeHttpGetIn" ref="Link1C"/>
					<Message type="output" name="s0:getUTCTimeHttpGetOut" ref="Link1D"/>
				</Messages>
			</Operation>
			<Operation id="Link1E" name="getOffesetUTCTime">
				<Messages>
					<Message type="input" name="s0:getOffesetUTCTimeHttpGetIn" ref="Link1F"/>
					<Message type="output" name="s0:getOffesetUTCTimeHttpGetOut" ref="Link20"/>
				</Messages>
			</Operation>
			<Operation id="Link21" name="getServerTime">
				<Messages>
					<Message type="input" name="s0:getServerTimeHttpGetIn" ref="Link22"/>
					<Message type="output" name="s0:getServerTimeHttpGetOut" ref="Link23"/>
				</Messages>
			</Operation>
			<Operation id="Link24" name="getServerTimeZone">
				<Messages>
					<Message type="input" name="s0:getServerTimeZoneHttpGetIn" ref="Link25"/>
					<Message type="output" name="s0:getServerTimeZoneHttpGetOut" ref="Link26"/>
				</Messages>
			</Operation>
			<Operation id="Link27" name="getServerCity">
				<Messages>
					<Message type="input" name="s0:getServerCityHttpGetIn" ref="Link28"/>
					<Message type="output" name="s0:getServerCityHttpGetOut" ref="Link29"/>
				</Messages>
			</Operation>
			<Operation id="Link2A" name="getTimeZoneTime">
				<Messages>
					<Message type="input" name="s0:getTimeZoneTimeHttpGetIn" ref="Link2B"/>
					<Message type="output" name="s0:getTimeZoneTimeHttpGetOut" ref="Link2C"/>
					<Message type="fault" name="s0:errorHttpGetOut" ref="Link2D"/>
				</Messages>
			</Operation>
			<Operation id="Link2E" name="getCityTime">
				<Messages>
					<Message type="input" name="s0:getCityTimeHttpGetIn" ref="Link2F"/>
					<Message type="output" name="s0:getCityTimeHttpGetOut" ref="Link30"/>
					<Message type="fault" name="s0:errorHttpGetOut" ref="Link2D"/>
				</Messages>
			</Operation>
		</Operations>
		<UsedBy>
			<Binding ref="Link15">TimeServiceHttpGet</Binding>
		</UsedBy>
		<Source>
			<portType name="TimeServiceHttpGet">
				<operation name="getUTCTime">
					<input message="s0:getUTCTimeHttpGetIn"/>
					<output message="s0:getUTCTimeHttpGetOut"/>
				</operation>
				<operation name="getOffesetUTCTime">
					<input message="s0:getOffesetUTCTimeHttpGetIn"/>
					<output message="s0:getOffesetUTCTimeHttpGetOut"/>
				</operation>
				<operation name="getServerTime">
					<input message="s0:getServerTimeHttpGetIn"/>
					<output message="s0:getServerTimeHttpGetOut"/>
				</operation>
				<operation name="getServerTimeZone">
					<input message="s0:getServerTimeZoneHttpGetIn"/>
					<output message="s0:getServerTimeZoneHttpGetOut"/>
				</operation>
				<operation name="getServerCity">
					<input message="s0:getServerCityHttpGetIn"/>
					<output message="s0:getServerCityHttpGetOut"/>
				</operation>
				<operation name="getTimeZoneTime">
					<input message="s0:getTimeZoneTimeHttpGetIn"/>
					<output message="s0:getTimeZoneTimeHttpGetOut"/>
					<fault name="FaultTimeZoneNotFound" message="s0:errorHttpGetOut"/>
				</operation>
				<operation name="getCityTime">
					<input message="s0:getCityTimeHttpGetIn"/>
					<output message="s0:getCityTimeHttpGetOut"/>
					<fault name="FaultCityNotFound" message="s0:errorHttpGetOut"/>
				</operation>
			</portType>
		</Source>
	</PortType>
	<PortType id="Link19" name="TimeServiceHttpPost">
		<Diagram src="TimeService_diagrams/TimeService_p6.png" width="281" height="738"/>
		<Operations>
			<Operation id="Link31" name="getUTCTime">
				<Messages>
					<Message type="input" name="s0:getUTCTimeHttpPostIn" ref="Link32"/>
					<Message type="output" name="s0:getUTCTimeHttpPostOut" ref="Link33"/>
				</Messages>
			</Operation>
			<Operation id="Link34" name="getOffesetUTCTime">
				<Messages>
					<Message type="input" name="s0:getOffesetUTCTimeHttpPostIn" ref="Link35"/>
					<Message type="output" name="s0:getOffesetUTCTimeHttpPostOut" ref="Link36"/>
				</Messages>
			</Operation>
			<Operation id="Link37" name="getServerTime">
				<Messages>
					<Message type="input" name="s0:getServerTimeHttpPostIn" ref="Link38"/>
					<Message type="output" name="s0:getServerTimeHttpPostOut" ref="Link39"/>
				</Messages>
			</Operation>
			<Operation id="Link3A" name="getServerTimeZone">
				<Messages>
					<Message type="input" name="s0:getServerTimeZoneHttpPostIn" ref="Link3B"/>
					<Message type="output" name="s0:getServerTimeZoneHttpPostOut" ref="Link3C"/>
				</Messages>
			</Operation>
			<Operation id="Link3D" name="getServerCity">
				<Messages>
					<Message type="input" name="s0:getServerCityHttpPostIn" ref="Link3E"/>
					<Message type="output" name="s0:getServerCityHttpPostOut" ref="Link3F"/>
				</Messages>
			</Operation>
			<Operation id="Link40" name="getTimeZoneTime">
				<Messages>
					<Message type="input" name="s0:getTimeZoneTimeHttpPostIn" ref="Link41"/>
					<Message type="output" name="s0:getTimeZoneTimeHttpPostOut" ref="Link42"/>
					<Message type="fault" name="s0:errorHttpPostOut" ref="Link43"/>
				</Messages>
			</Operation>
			<Operation id="Link44" name="getCityTime">
				<Messages>
					<Message type="input" name="s0:getCityTimeHttpPostIn" ref="Link45"/>
					<Message type="output" name="s0:getCityTimeHttpPostOut" ref="Link46"/>
					<Message type="fault" name="s0:errorHttpPostOut" ref="Link43"/>
				</Messages>
			</Operation>
		</Operations>
		<UsedBy>
			<Binding ref="Link17">TimeServiceHttpPost</Binding>
		</UsedBy>
		<Source>
			<portType name="TimeServiceHttpPost">
				<operation name="getUTCTime">
					<input message="s0:getUTCTimeHttpPostIn"/>
					<output message="s0:getUTCTimeHttpPostOut"/>
				</operation>
				<operation name="getOffesetUTCTime">
					<input message="s0:getOffesetUTCTimeHttpPostIn"/>
					<output message="s0:getOffesetUTCTimeHttpPostOut"/>
				</operation>
				<operation name="getServerTime">
					<input message="s0:getServerTimeHttpPostIn"/>
					<output message="s0:getServerTimeHttpPostOut"/>
				</operation>
				<operation name="getServerTimeZone">
					<input message="s0:getServerTimeZoneHttpPostIn"/>
					<output message="s0:getServerTimeZoneHttpPostOut"/>
				</operation>
				<operation name="getServerCity">
					<input message="s0:getServerCityHttpPostIn"/>
					<output message="s0:getServerCityHttpPostOut"/>
				</operation>
				<operation name="getTimeZoneTime">
					<input message="s0:getTimeZoneTimeHttpPostIn"/>
					<output message="s0:getTimeZoneTimeHttpPostOut"/>
					<fault name="FaultTimeZoneNotFound" message="s0:errorHttpPostOut"/>
				</operation>
				<operation name="getCityTime">
					<input message="s0:getCityTimeHttpPostIn"/>
					<output message="s0:getCityTimeHttpPostOut"/>
					<fault name="FaultCityNotFound" message="s0:errorHttpPostOut"/>
				</operation>
			</portType>
		</Source>
	</PortType>
	<PortType id="Link1A" name="TimeServiceSoap">
		<Diagram src="TimeService_diagrams/TimeService_p7.png" width="326" height="810"/>
		<Operations>
			<Operation id="Link47" name="getUTCTime">
				<Messages>
					<Message type="input" name="s0:getUTCTimeSoapIn" ref="Link48"/>
					<Message type="output" name="s0:getUTCTimeSoapOut" ref="Link49"/>
				</Messages>
			</Operation>
			<Operation id="Link4A" name="getOffesetUTCTime">
				<Messages>
					<Message type="input" name="s0:getOffesetUTCTimeSoapIn" ref="Link4B"/>
					<Message type="output" name="s0:getOffesetUTCTimeSoapOut" ref="Link4C"/>
				</Messages>
			</Operation>
			<Operation id="Link4D" name="getServerTime">
				<Messages>
					<Message type="input" name="s0:getServerTimeSoapIn" ref="Link4E"/>
					<Message type="output" name="s0:getServerTimeSoapOut" ref="Link4F"/>
				</Messages>
			</Operation>
			<Operation id="Link50" name="getServerTimeZone">
				<Messages>
					<Message type="input" name="s0:getServerTimeZoneSoapIn" ref="Link51"/>
					<Message type="output" name="s0:getServerTimeZoneSoapOut" ref="Link52"/>
				</Messages>
			</Operation>
			<Operation id="Link53" name="getServerCity">
				<Messages>
					<Message type="input" name="s0:getServerCitySoapIn" ref="Link54"/>
					<Message type="output" name="s0:getServerCitySoapOut" ref="Link55"/>
				</Messages>
			</Operation>
			<Operation id="Link56" name="getTimeZoneTime">
				<Messages>
					<Message type="input" name="s0:getTimeZoneTimeSoapIn" ref="Link57"/>
					<Message type="output" name="s0:getTimeZoneTimeSoapOut" ref="Link58"/>
					<Message type="fault" name="s0:errorSoapOut" ref="Link59"/>
				</Messages>
			</Operation>
			<Operation id="Link5A" name="getCityTime">
				<Messages>
					<Message type="input" name="s0:getCityTimeSoapIn" ref="Link5B"/>
					<Message type="output" name="s0:getCityTimeSoapOut" ref="Link5C"/>
					<Message type="fault" name="s0:errorSoapOut" ref="Link59"/>
				</Messages>
			</Operation>
		</Operations>
		<UsedBy>
			<Binding ref="Link13">TimeServiceSoap</Binding>
		</UsedBy>
		<Source>
			<portType name="TimeServiceSoap">
				<operation name="getUTCTime">
					<input message="s0:getUTCTimeSoapIn"/>
					<output message="s0:getUTCTimeSoapOut"/>
				</operation>
				<operation name="getOffesetUTCTime">
					<input message="s0:getOffesetUTCTimeSoapIn"/>
					<output message="s0:getOffesetUTCTimeSoapOut"/>
				</operation>
				<operation name="getServerTime">
					<input message="s0:getServerTimeSoapIn"/>
					<output message="s0:getServerTimeSoapOut"/>
				</operation>
				<operation name="getServerTimeZone">
					<input message="s0:getServerTimeZoneSoapIn"/>
					<output message="s0:getServerTimeZoneSoapOut"/>
				</operation>
				<operation name="getServerCity">
					<input message="s0:getServerCitySoapIn"/>
					<output message="s0:getServerCitySoapOut"/>
				</operation>
				<operation name="getTimeZoneTime">
					<input message="s0:getTimeZoneTimeSoapIn"/>
					<output message="s0:getTimeZoneTimeSoapOut"/>
					<fault name="FaultTimeZoneNotFound" message="s0:errorSoapOut"/>
				</operation>
				<operation name="getCityTime">
					<input message="s0:getCityTimeSoapIn"/>
					<output message="s0:getCityTimeSoapOut"/>
					<fault name="FaultCityNotFound" message="s0:errorSoapOut"/>
				</operation>
			</portType>
		</Source>
	</PortType>
	<Message id="Link2D" name="errorHttpGetOut">
		<Parts>
			<Part name="Error">
				<Element ref="Link1">s0:errorResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link2A">getTimeZoneTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
			<By>
				<Operation ref="Link2E">getCityTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="errorHttpGetOut">
				<part name="Error" element="s0:errorResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link43" name="errorHttpPostOut">
		<Parts>
			<Part name="Error">
				<Element ref="Link1">s0:errorResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link40">getTimeZoneTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
			<By>
				<Operation ref="Link44">getCityTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="errorHttpPostOut">
				<part name="Error" element="s0:errorResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link59" name="errorSoapOut">
		<Parts>
			<Part name="Error">
				<Element ref="Link1">s0:errorResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link56">getTimeZoneTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
			<By>
				<Operation ref="Link5A">getCityTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="errorSoapOut">
				<part name="Error" element="s0:errorResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link2F" name="getCityTimeHttpGetIn">
		<Parts>
			<Part name="city">
				<Type>s:string</Type>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link2E">getCityTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getCityTimeHttpGetIn">
				<part name="city" type="s:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link30" name="getCityTimeHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link2E">getCityTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getCityTimeHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link45" name="getCityTimeHttpPostIn">
		<Parts>
			<Part name="city">
				<Type>s:string</Type>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link44">getCityTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getCityTimeHttpPostIn">
				<part name="city" type="s:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link46" name="getCityTimeHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link44">getCityTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getCityTimeHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link5B" name="getCityTimeSoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="Link2">s0:getCityTime</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link5A">getCityTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getCityTimeSoapIn">
				<part name="parameters" element="s0:getCityTime"/>
			</message>
		</Source>
	</Message>
	<Message id="Link5C" name="getCityTimeSoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="Link3">s0:getCityTimeResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link5A">getCityTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getCityTimeSoapOut">
				<part name="parameters" element="s0:getCityTimeResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link1F" name="getOffesetUTCTimeHttpGetIn">
		<Parts>
			<Part name="hoursOffset">
				<Type>s:string</Type>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link1E">getOffesetUTCTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getOffesetUTCTimeHttpGetIn">
				<part name="hoursOffset" type="s:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link20" name="getOffesetUTCTimeHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link1E">getOffesetUTCTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getOffesetUTCTimeHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link35" name="getOffesetUTCTimeHttpPostIn">
		<Parts>
			<Part name="hoursOffset">
				<Type>s:string</Type>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link34">getOffesetUTCTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getOffesetUTCTimeHttpPostIn">
				<part name="hoursOffset" type="s:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link36" name="getOffesetUTCTimeHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link34">getOffesetUTCTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getOffesetUTCTimeHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link4B" name="getOffesetUTCTimeSoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="Link4">s0:getOffesetUTCTime</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link4A">getOffesetUTCTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getOffesetUTCTimeSoapIn">
				<part name="parameters" element="s0:getOffesetUTCTime"/>
			</message>
		</Source>
	</Message>
	<Message id="Link4C" name="getOffesetUTCTimeSoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="Link5">s0:getOffesetUTCTimeResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link4A">getOffesetUTCTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getOffesetUTCTimeSoapOut">
				<part name="parameters" element="s0:getOffesetUTCTimeResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link28" name="getServerCityHttpGetIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link27">getServerCity</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerCityHttpGetIn"/>
		</Source>
	</Message>
	<Message id="Link29" name="getServerCityHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link27">getServerCity</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerCityHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link3E" name="getServerCityHttpPostIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link3D">getServerCity</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerCityHttpPostIn"/>
		</Source>
	</Message>
	<Message id="Link3F" name="getServerCityHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link3D">getServerCity</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerCityHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link54" name="getServerCitySoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="Link6">s0:getServerCity</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link53">getServerCity</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerCitySoapIn">
				<part name="parameters" element="s0:getServerCity"/>
			</message>
		</Source>
	</Message>
	<Message id="Link55" name="getServerCitySoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="Link7">s0:getServerCityResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link53">getServerCity</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerCitySoapOut">
				<part name="parameters" element="s0:getServerCityResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link22" name="getServerTimeHttpGetIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link21">getServerTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeHttpGetIn"/>
		</Source>
	</Message>
	<Message id="Link23" name="getServerTimeHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link21">getServerTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link38" name="getServerTimeHttpPostIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link37">getServerTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeHttpPostIn"/>
		</Source>
	</Message>
	<Message id="Link39" name="getServerTimeHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link37">getServerTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link4E" name="getServerTimeSoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="Link8">s0:getServerTime</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link4D">getServerTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeSoapIn">
				<part name="parameters" element="s0:getServerTime"/>
			</message>
		</Source>
	</Message>
	<Message id="Link4F" name="getServerTimeSoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="Link9">s0:getServerTimeResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link4D">getServerTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeSoapOut">
				<part name="parameters" element="s0:getServerTimeResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link25" name="getServerTimeZoneHttpGetIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link24">getServerTimeZone</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeZoneHttpGetIn"/>
		</Source>
	</Message>
	<Message id="Link26" name="getServerTimeZoneHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link24">getServerTimeZone</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeZoneHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link3B" name="getServerTimeZoneHttpPostIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link3A">getServerTimeZone</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeZoneHttpPostIn"/>
		</Source>
	</Message>
	<Message id="Link3C" name="getServerTimeZoneHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link3A">getServerTimeZone</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeZoneHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link51" name="getServerTimeZoneSoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="LinkA">s0:getServerTimeZone</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link50">getServerTimeZone</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeZoneSoapIn">
				<part name="parameters" element="s0:getServerTimeZone"/>
			</message>
		</Source>
	</Message>
	<Message id="Link52" name="getServerTimeZoneSoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="LinkB">s0:getServerTimeZoneResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link50">getServerTimeZone</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getServerTimeZoneSoapOut">
				<part name="parameters" element="s0:getServerTimeZoneResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link2B" name="getTimeZoneTimeHttpGetIn">
		<Parts>
			<Part name="timezone">
				<Type>s:string</Type>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link2A">getTimeZoneTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getTimeZoneTimeHttpGetIn">
				<part name="timezone" type="s:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link2C" name="getTimeZoneTimeHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link2A">getTimeZoneTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getTimeZoneTimeHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link41" name="getTimeZoneTimeHttpPostIn">
		<Parts>
			<Part name="timezone">
				<Type>s:string</Type>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link40">getTimeZoneTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getTimeZoneTimeHttpPostIn">
				<part name="timezone" type="s:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link42" name="getTimeZoneTimeHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link40">getTimeZoneTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getTimeZoneTimeHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link57" name="getTimeZoneTimeSoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="LinkC">s0:getTimeZoneTime</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link56">getTimeZoneTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getTimeZoneTimeSoapIn">
				<part name="parameters" element="s0:getTimeZoneTime"/>
			</message>
		</Source>
	</Message>
	<Message id="Link58" name="getTimeZoneTimeSoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="LinkD">s0:getTimeZoneTimeResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link56">getTimeZoneTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getTimeZoneTimeSoapOut">
				<part name="parameters" element="s0:getTimeZoneTimeResponse"/>
			</message>
		</Source>
	</Message>
	<Message id="Link1C" name="getUTCTimeHttpGetIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link1B">getUTCTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getUTCTimeHttpGetIn"/>
		</Source>
	</Message>
	<Message id="Link1D" name="getUTCTimeHttpGetOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link1B">getUTCTime</Operation>
				<PortType ref="Link18">TimeServiceHttpGet</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getUTCTimeHttpGetOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link32" name="getUTCTimeHttpPostIn">
		<Parts/>
		<UsedBy>
			<By>
				<Operation ref="Link31">getUTCTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getUTCTimeHttpPostIn"/>
		</Source>
	</Message>
	<Message id="Link33" name="getUTCTimeHttpPostOut">
		<Parts>
			<Part name="Body">
				<Element ref="Link10">s0:string</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link31">getUTCTime</Operation>
				<PortType ref="Link19">TimeServiceHttpPost</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getUTCTimeHttpPostOut">
				<part name="Body" element="s0:string"/>
			</message>
		</Source>
	</Message>
	<Message id="Link48" name="getUTCTimeSoapIn">
		<Parts>
			<Part name="parameters">
				<Element ref="LinkE">s0:getUTCTime</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link47">getUTCTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getUTCTimeSoapIn">
				<part name="parameters" element="s0:getUTCTime"/>
			</message>
		</Source>
	</Message>
	<Message id="Link49" name="getUTCTimeSoapOut">
		<Parts>
			<Part name="parameters">
				<Element ref="LinkF">s0:getUTCTimeResponse</Element>
			</Part>
		</Parts>
		<UsedBy>
			<By>
				<Operation ref="Link47">getUTCTime</Operation>
				<PortType ref="Link1A">TimeServiceSoap</PortType>
			</By>
		</UsedBy>
		<Source>
			<message name="getUTCTimeSoapOut">
				<part name="parameters" element="s0:getUTCTimeResponse"/>
			</message>
		</Source>
	</Message>
	<SchemaDocument schemaLocation="TimeService.wsdl" href="TimeService.wsdl" attributeFormDefault="" elementFormDefault="qualified" targetNamespace="http://www.Nanonull.com/TimeService/">
		<Element name="errorResponse" wsdlType="true" id="Link1">
			<Diagram src="TimeService_diagrams/TimeService_p8.png" width="300" height="68"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:errorText</Child>
				<Child>s0:errorItem</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="errorResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="errorText" type="s:string" minOccurs="0" maxOccurs="1"/>
							<s:element name="errorItem" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getCityTime" wsdlType="true" id="Link2">
			<Diagram src="TimeService_diagrams/TimeService_p9.png" width="234" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:city</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getCityTime">
					<s:complexType>
						<s:sequence>
							<s:element name="city" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getCityTimeResponse" wsdlType="true" id="Link3">
			<Diagram src="TimeService_diagrams/TimeService_p10.png" width="372" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getCityTimeResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getCityTimeResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getCityTimeResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getOffesetUTCTime" wsdlType="true" id="Link4">
			<Diagram src="TimeService_diagrams/TimeService_p11.png" width="323" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:hoursOffset</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getOffesetUTCTime">
					<s:complexType>
						<s:sequence>
							<s:element name="hoursOffset" type="s:double" minOccurs="1" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getOffesetUTCTimeResponse" wsdlType="true" id="Link5">
			<Diagram src="TimeService_diagrams/TimeService_p12.png" width="456" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getOffesetUTCTimeResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getOffesetUTCTimeResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getOffesetUTCTimeResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getServerCity" wsdlType="true" id="Link6">
			<Diagram src="TimeService_diagrams/TimeService_p13.png" width="116" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getServerCity">
					<s:complexType/>
				</s:element>
			</Source>
		</Element>
		<Element name="getServerCityResponse" wsdlType="true" id="Link7">
			<Diagram src="TimeService_diagrams/TimeService_p14.png" width="390" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getServerCityResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getServerCityResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getServerCityResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getServerTime" wsdlType="true" id="Link8">
			<Diagram src="TimeService_diagrams/TimeService_p15.png" width="123" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getServerTime">
					<s:complexType/>
				</s:element>
			</Source>
		</Element>
		<Element name="getServerTimeResponse" wsdlType="true" id="Link9">
			<Diagram src="TimeService_diagrams/TimeService_p16.png" width="404" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getServerTimeResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getServerTimeResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getServerTimeResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getServerTimeZone" wsdlType="true" id="LinkA">
			<Diagram src="TimeService_diagrams/TimeService_p17.png" width="151" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getServerTimeZone">
					<s:complexType/>
				</s:element>
			</Source>
		</Element>
		<Element name="getServerTimeZoneResponse" wsdlType="true" id="LinkB">
			<Diagram src="TimeService_diagrams/TimeService_p18.png" width="460" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getServerTimeZoneResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getServerTimeZoneResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getServerTimeZoneResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getTimeZoneTime" wsdlType="true" id="LinkC">
			<Diagram src="TimeService_diagrams/TimeService_p19.png" width="301" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:timezone</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getTimeZoneTime">
					<s:complexType>
						<s:sequence>
							<s:element name="timezone" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getTimeZoneTimeResponse" wsdlType="true" id="LinkD">
			<Diagram src="TimeService_diagrams/TimeService_p20.png" width="442" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getTimeZoneTimeResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getTimeZoneTimeResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getTimeZoneTimeResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="getUTCTime" wsdlType="true" id="LinkE">
			<Diagram src="TimeService_diagrams/TimeService_p21.png" width="108" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getUTCTime">
					<s:complexType/>
				</s:element>
			</Source>
		</Element>
		<Element name="getUTCTimeResponse" wsdlType="true" id="LinkF">
			<Diagram src="TimeService_diagrams/TimeService_p22.png" width="374" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Properties>
				<Property name="content">complex</Property>
			</Properties>
			<Children>
				<Child>s0:getUTCTimeResult</Child>
			</Children>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="getUTCTimeResponse">
					<s:complexType>
						<s:sequence>
							<s:element name="getUTCTimeResult" type="s:string" minOccurs="0" maxOccurs="1"/>
						</s:sequence>
					</s:complexType>
				</s:element>
			</Source>
		</Element>
		<Element name="string" wsdlType="true" id="Link10">
			<Diagram src="TimeService_diagrams/TimeService_p23.png" width="76" height="35"/>
			<Namespace>http://www.Nanonull.com/TimeService/</Namespace>
			<Type>
				<Reference>s:string</Reference>
			</Type>
			<Properties>
				<Property name="content">simple</Property>
				<Property name="nillable">true</Property>
			</Properties>
			<Source xmlns:s="http://www.w3.org/2001/XMLSchema">
				<s:element name="string" type="s:string" nillable="true"/>
			</Source>
		</Element>
	</SchemaDocument>
</WSDLDocumentation>