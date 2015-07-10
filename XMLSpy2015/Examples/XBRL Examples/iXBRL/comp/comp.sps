<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ct" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct/2009-07-03"/>
			<nspair prefix="ct-CG" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-CG/2009-07-03"/>
			<nspair prefix="ct-CT" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-CT/2009-07-03"/>
			<nspair prefix="ct-CaseI" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-CaseI/2009-07-03"/>
			<nspair prefix="ct-CaseV" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-CaseV/2009-07-03"/>
			<nspair prefix="ct-DR" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-DR/2009-07-03"/>
			<nspair prefix="ct-OtherInc" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-OtherInc/2009-07-03"/>
			<nspair prefix="ct-PL" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-PL/2009-07-03"/>
			<nspair prefix="ct-SchA" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-SchA/2009-07-03"/>
			<nspair prefix="ct-Tax" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-Tax/2009-07-03"/>
			<nspair prefix="ct-default" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-default/2009-07-03"/>
			<nspair prefix="ct-roles" uri="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-roles/2009-07-03"/>
			<nspair prefix="xl" uri="http://www.xbrl.org/2003/XLink"/>
		</namespaces>
		<schemasources>
			<xbrlschemasource name="XBRL" main="1" schemafile="taxonomies\comp\2009-07-03\ct-2009-07-03.xsd" workingxmlfile="comp.xml" label-lang="en" label-role="http://www.xbrl.org/2003/role/label" label-link-role="http://www.xbrl.org/2003/role/link" use-preferred-label-role="1" try-standard-label-role="1"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
		<xpath-functions/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="2" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles>
		<rules selector=".total">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom-color="black" border-bottom-style="double" border-top="1px solid black"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XBRL">
						<children>
							<template subtype="xbrl-linkrole" match="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-roles/2009-07-03/role/MandatoryItems">
								<editorproperties label-lang="inherit" label-role="inherit" label-link-role="inherit"/>
								<children>
									<tgrid>
										<children>
											<tgridheader-cols>
												<children>
													<tgridcol/>
												</children>
											</tgridheader-cols>
											<tgridbody-cols>
												<children>
													<template subtype="xbrl-period" show-duration-periods="0" show-forever-periods="0" match="xbrli:period">
														<sort>
															<key match="if ( exists( xbrli:instant ) ) then xbrli:instant else if ( exists( xbrli:endDate ) ) then xbrli:endDate else &apos;forever&apos;" order="descending"/>
														</sort>
														<children>
															<tgridcol/>
														</children>
														<variables>
															<variable name="period" value="." valuetype="&lt;auto&gt;"/>
														</variables>
													</template>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<text fixtext="Name:"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CT:DescriptorCompanyName">
																		<children>
																			<calltemplate subtype="named" match="ix_string">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<text fixtext="Tax Reference:"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CT:DescriptorTaxReference">
																		<children>
																			<calltemplate subtype="named" match="ix_string">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<text fixtext="Return for period:"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<template subtype="xbrl-item" match="ct-CT:DescriptorStartOfPeriodForWhichReturnRequired">
																		<children>
																			<text fixtext="from "/>
																			<calltemplate subtype="named" match="ix_dateYY">
																				<parameters/>
																			</calltemplate>
																			<text fixtext=" to "/>
																			<template subtype="source" match="XBRL">
																				<children>
																					<template subtype="xbrl-item" match="ct-CT:DescriptorEndOfPeriodForWhichReturnRequired">
																						<children>
																							<calltemplate subtype="named" match="ix_dateYYYY">
																								<parameters/>
																							</calltemplate>
																						</children>
																						<variables/>
																					</template>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" "/>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="xbrl-linkrole" match="http://www.govtalk.gov.uk/uk/fr/tax/uk-hmrc-ct-roles/2009-07-03/role/MandatoryItems">
								<editorproperties label-lang="inherit" label-role="inherit" label-link-role="inherit"/>
								<children>
									<tgrid>
										<children>
											<tgridheader-cols>
												<children>
													<tgridcol/>
												</children>
											</tgridheader-cols>
											<tgridbody-cols>
												<children>
													<tgridcol/>
													<template subtype="xbrl-period" show-instant-periods="0" show-forever-periods="0" match="xbrli:period">
														<sort>
															<key match="if ( exists( xbrli:instant ) ) then xbrli:instant else if ( exists( xbrli:endDate ) ) then xbrli:endDate else &apos;forever&apos;" order="descending"/>
														</sort>
														<children>
															<tgridcol/>
															<tgridcol/>
															<tgridcol/>
															<tgridcol/>
															<tgridcol/>
														</children>
														<variables>
															<variable name="period" value="." valuetype="&lt;auto&gt;"/>
														</variables>
													</template>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<text fixtext="A. Corporation Tax"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-unit" match="xbrli:unit">
																		<children>
																			<calltemplate subtype="element" match="xbrli:measure"/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-unit" match="xbrli:unit">
																		<children>
																			<calltemplate subtype="element" match="xbrli:measure"/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Trading Profits"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsTotalProfitsAllTrades">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Non-trading loan relationships"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-default:InvestmentIncomeAndReliefsNonTradingLoanRelationshipsProfitsAndGainsFromNTLR">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Profits Chargeable"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityProfits">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Financial year "/>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityFinancialYear1Date">
																		<children>
																			<calltemplate subtype="named" match="ix_gYear">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityFinancialYear1AmountOfProfitChargeableAtFirstRate">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityFinancialYear1FirstRateOfTax">
																		<children>
																			<text fixtext="@"/>
																			<autocalc xpath="number(.) * 100">
																				<format basic-type="ixbrl" ixbrl-element="nonFraction" ixbrl-formatcode-ex="numdot" ixbrl-inputformat="0.##########{sep=,,dec=.}" ixbrl-scale="-2"/>
																			</autocalc>
																			<text fixtext="%"/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityFinancialYear1TaxAtFirstRate">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma2">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<properties class="xbrl-row-data xbrl-row-even xbrl-row-level-0"/>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Corporation tax"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityCorporationTax">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma2">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Corporation tax chargeable"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityCTChargeable">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma2">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="C"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#C"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="Double taxation relief"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="doubletaxationrelief"/>
																		</bookmark>
																	</bookmark>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityDoubleTaxationReliefAmount">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma2">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Total reliefs and deductions in terms of tax"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityTotalReliefsDeductionsInTermsOfTax">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma2">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Net corporation tax liability"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-Tax:CalculationOfCTLiabilityCTLiability">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma2">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<text fixtext="B. Trading Profits"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell>
																<styles text-align="left"/>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-unit" match="xbrli:unit">
																		<children>
																			<calltemplate subtype="element" match="xbrli:measure"/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Profits per accounts"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeProfitPerAccounts">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Depreciation"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeAdjustmentsDepreciation">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Amortisation"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeAdjustmentsAmortisation">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Capital expenditure"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeAdjustmentsCapitalExpenditure">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="B1"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#B1"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="Legal and professional"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="legalandprofessional"/>
																		</bookmark>
																	</bookmark>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeAdjustmentsAccountancyLegalAndProfessionalFees">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Entertaining"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeAdjustmentsEntertaining">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Interest receivable"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeAdjustmentsNTLRCreditsPerAccounts">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="B2"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#B2"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="Capital allowances"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeCapitalAllowancesNetAllowancesCharges">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Adjusted profits"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeNetTradingProfitsIndividualTrade">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="B1"/>
																		</bookmark>
																	</bookmark>
																	<text fixtext="B1. Legal and professional"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="Total"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="Disallowed"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Solicitor"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="31,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="-"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Surveyor"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="49,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="49,000"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
															</tgridcell>
															<tgridcell/>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<text fixtext="80,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="49,000"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#legalandprofessional"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="B2"/>
																		</bookmark>
																	</bookmark>
																	<text fixtext="B2. Capital allowances"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Plant and machinery">
																		<styles font-style="italic"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="Total allowances"/>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Brought forward"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-period-startend" match="xbrli:period">
																		<children>
																			<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAGeneralPoolWDVBF">
																				<children>
																					<calltemplate subtype="named" match="ix_monetary_PostComma0">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="B2.1"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#B21"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="Additions qualifying for WDA"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="additionsQualifyingForWDA"/>
																		</bookmark>
																	</bookmark>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAGeneralPoolExpenditureQualifyingForWDA">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="WDA"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAGeneralPoolWritingDownAllowances">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAGeneralPoolTotalAllowances">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Carried forward"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-period-startend" period-filter="endDate" match="xbrli:period">
																		<children>
																			<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAGeneralPoolWDVCF">
																				<children>
																					<calltemplate subtype="named" match="ix_monetary_PostComma0">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Cars not in main pool">
																		<styles font-style="italic"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="No of cars"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAExpensiveCarsSummaryNumberOfSingleAssetPools">
																		<children>
																			<content>
																				<format basic-type="ixbrl" ixbrl-element="nonFraction" ixbrl-formatcode-ex="numdot" ixbrl-inputformat="0.##########{sep=,,dec=.}"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Registration"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="ABC 123"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="DEF 345"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="GHI 678"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
															</tgridcell>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Additions"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="30,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="30,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="30,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAExpensiveCarsSummaryExpenditureQualifyingForWDATotal">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="WDA"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="3,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="3,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="3,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAExpensiveCarsSummaryWritingDownAllowancesTotal">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAExpensiveCarsSummaryTotalAllowancesTotal">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Carried forward"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<text fixtext="27,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<text fixtext="27,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<text fixtext="27,000"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-period-startend" period-filter="endDate" match="xbrli:period">
																		<children>
																			<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradePMAExpensiveCarsSummaryWDVCFTotal">
																				<children>
																					<calltemplate subtype="named" match="ix_monetary_PostComma0">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Total Allowances"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<template subtype="xbrl-item" match="ct-CaseI:TradingProfitsIndividualTradeCapitalAllowancesSummaryTotalAllowances">
																		<children>
																			<calltemplate subtype="named" match="ix_monetary_PostComma0">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="B21"/>
																		</bookmark>
																	</bookmark>
																	<text fixtext="B2.1 Additions to main pool"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Fixed asset additions"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="648,000"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Capital expenditure in revenue"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="2,000"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="650,000"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#additionsQualifyingForWDA"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles text-align="left"/>
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<fixtext value="C"/>
																		</bookmark>
																	</bookmark>
																	<text fixtext="C Double taxation relief"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="Spanish"/>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<text fixtext="French"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Foreign tax"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="15,000.00"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="30,000.00"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="UK tax on profits"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="17,000.00"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="30,000.00"/>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<text fixtext="Double taxation relief"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="15,000.00"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="30,000.00"/>
																</children>
															</tgridcell>
															<tgridcell>
																<properties class="total"/>
																<styles text-align="right"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="45,000.00"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#doubletaxationrelief"/>
																		</hyperlink>
																	</link>
																</children>
															</tgridcell>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="xbrli:measure" schema-tree-path="xbrli:measure">
				<children>
					<template subtype="element" match="xbrli:measure">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="fn:resolve-QName( text(), . ) eq fn:QName( &apos;http://www.xbrl.org/2003/iso4217&apos;, &apos;USD&apos; )">
										<children>
											<text fixtext="$"/>
										</children>
									</conditionbranch>
									<conditionbranch xpath="fn:resolve-QName( text(), . ) eq fn:QName( &apos;http://www.xbrl.org/2003/iso4217&apos;, &apos;EUR&apos; )">
										<children>
											<text fixtext="€"/>
										</children>
									</conditionbranch>
									<conditionbranch xpath="fn:resolve-QName( text(), . ) eq fn:QName( &apos;http://www.xbrl.org/2003/iso4217&apos;, &apos;GBP&apos; )">
										<children>
											<text fixtext="£"/>
										</children>
									</conditionbranch>
									<conditionbranch xpath="fn:resolve-QName( text(), . ) eq fn:QName( &apos;http://www.xbrl.org/2003/iso4217&apos;, &apos;JPY&apos; )">
										<children>
											<text fixtext="¥"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="ix_monetary_PostComma0">
				<parameters/>
				<children>
					<condition>
						<children>
							<conditionbranch xpath="number( . ) &gt;= 0">
								<children>
									<autocalc xpath="number( . )">
										<format basic-type="ixbrl" ixbrl-element="nonFraction" ixbrl-formatcode-ex="numcommadot" ixbrl-inputformat="#,##0.##########{sep=,,dec=.}"/>
									</autocalc>
								</children>
							</conditionbranch>
							<conditionbranch>
								<children>
									<autocalc xpath="number( . ) * -1">
										<format basic-type="ixbrl" ixbrl-element="nonFraction" ixbrl-formatcode-ex="numcommadot" ixbrl-inputformat="#,##0.##########{sep=,,dec=.}"/>
									</autocalc>
								</children>
							</conditionbranch>
						</children>
					</condition>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="ix_gYear">
				<parameters/>
				<children>
					<content>
						<format basic-type="ixbrl" ixbrl-element="nonNumeric" ixbrl-formatcode-ex="arbitrary"/>
					</content>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="decimalItemType">
				<parameters/>
				<children>
					<content/>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="integerItemType">
				<parameters/>
				<children>
					<content/>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="pureItemType">
				<parameters/>
				<children>
					<content/>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="ix_string">
				<parameters/>
				<children>
					<content>
						<format basic-type="ixbrl" ixbrl-element="nonNumeric" ixbrl-formatcode-ex="arbitrary"/>
					</content>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="ix_dateYYYY">
				<parameters/>
				<children>
					<content>
						<format basic-type="ixbrl" ixbrl-element="nonNumeric" ixbrl-formatcode-ex="dateslasheu4" ixbrl-inputformat="DD/MM/YYYY"/>
					</content>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="booleanItemType">
				<parameters/>
				<children>
					<content/>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="dateTimeItemType">
				<parameters/>
				<children>
					<content/>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="ix_monetary_PostComma2">
				<parameters/>
				<children>
					<condition>
						<children>
							<conditionbranch xpath="number( . ) &gt;= 0">
								<children>
									<autocalc xpath="number( . )">
										<format basic-type="ixbrl" ixbrl-element="nonFraction" ixbrl-formatcode-ex="numcommadot" ixbrl-inputformat="#,##0.00########{sep=,,dec=.}"/>
									</autocalc>
								</children>
							</conditionbranch>
							<conditionbranch>
								<children>
									<autocalc xpath="number( . ) * -1">
										<format basic-type="ixbrl" ixbrl-element="nonFraction" ixbrl-formatcode-ex="numcommadot" ixbrl-inputformat="#,##0.00########{sep=,,dec=.}"/>
									</autocalc>
								</children>
							</conditionbranch>
						</children>
					</condition>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="ix_dateYY">
				<parameters/>
				<children>
					<content>
						<format basic-type="ixbrl" ixbrl-element="nonNumeric" ixbrl-formatcode-ex="dateslasheu2" ixbrl-inputformat="DD/MM/YY"/>
					</content>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
