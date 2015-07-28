<?xml version="1.0" encoding="UTF-8"?>
<structure version="4" cssmode="quirks" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="$XML" main="1" schemafile="BusinessRule.xsd" workingxmlfile="XML\F4557.xml">
				<xmltablesupport/>
				<textstateicons/>
			</xsdschemasource>
		</schemasources>
	</schemasources>
	<scripts>
		<javascript name="javascript"/>
	</scripts>
	<globalstyles/>
	<parts>
		<editorproperties/>
		<properties/>
		<styles/>
		<children>
			<globaltemplate match="/">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="$XML">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="businessLogic">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="add">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="add">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" + ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="and">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="and">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles border-collapse="collapse"/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="center" valign="middle" width="45"/>
														<styles/>
														<children>
															<text fixtext="AND">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<table>
																<editorproperties/>
																<properties border="1" width="100%"/>
																<styles border-collapse="collapse"/>
																<children>
																	<tablebody>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<template match="condition">
																				<editorproperties elementstodisplay="1" elementstofetch="all"/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablerow>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablecell>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																										<addvalidations/>
																										<format/>
																									</content>
																								</children>
																							</tablecell>
																						</children>
																					</tablerow>
																				</children>
																				<addvalidations/>
																				<sort/>
																			</template>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="bcm">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="bcm">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="bcm(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<combobox>
								<editorproperties/>
								<properties/>
								<styles width="262px"/>
								<children>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<selectoption description="Accident.dateDeNaissanceAssure" value="772"/>
								<selectoption description="Accident.entite" value="1120"/>
								<selectoption description="Accident.gensMaisonCodeNACE" value="776"/>
								<selectoption description="Accident.gensMaisonNumeroONSS" value="777"/>
								<selectoption description="Accident.libelleParticulariteGestion" value="768"/>
								<selectoption description="Accident.natureDuRisquePrincipal" value="771"/>
								<selectoption description="Accident.nombreDePersonnesAssurees" value="770"/>
								<selectoption description="Accident.particularitesGestion" value="1083"/>
								<selectoption description="Accident.particularitesGestion[1]" value="1081"/>
								<selectoption description="Accident.particularitesGestion[2]" value="767"/>
								<selectoption description="Accident.particularitesProduitUUAP" value="775"/>
								<selectoption description="Accident.professionPrincipale" value="769"/>
								<selectoption description="Accident.sexeDeLAssure" value="774"/>
								<selectoption description="Accident.typeDAssure" value="773"/>
								<selectoption description="Agenda.datePlanifiee" value="684"/>
								<selectoption description="Agenda.destinataire" value="687"/>
								<selectoption description="Agenda.langue" value="688"/>
								<selectoption description="Agenda.libelleLibre" value="685"/>
								<selectoption description="Agenda.numeroDeLettre" value="683"/>
								<selectoption description="Agenda.numeroGestionnaire" value="689"/>
								<selectoption description="Agenda.rappel" value="686"/>
								<selectoption description="Agenda.type" value="690"/>
								<selectoption description="Agreement.BMaPosteriori" value="165"/>
								<selectoption description="Agreement.antecedentsTempo1" value="212"/>
								<selectoption description="Agreement.antecedentsTempo2" value="287"/>
								<selectoption description="Agreement.applicationOrigineDuContrat" value="1261"/>
								<selectoption description="Agreement.attestationSinistreDelivree" value="166"/>
								<selectoption description="Agreement.branche" value="156"/>
								<selectoption description="Agreement.canalDeGestion" value="39"/>
								<selectoption description="Agreement.codeDeterminationCiePourAccesTablesAnnexes" value="972"/>
								<selectoption description="Agreement.codeEMIRegionDerogatoireDuCourtier" value="285"/>
								<selectoption description="Agreement.codeSINRegionDerogatoireDuCourtier" value="284"/>
								<selectoption description="Agreement.compagnieDEmission" value="7"/>
								<selectoption description="Agreement.compagnieDOrigine" value="167"/>
								<selectoption description="Agreement.compagnieDeGestion" value="40"/>
								<selectoption description="Agreement.contratDOrigineUAB" value="164"/>
								<selectoption description="Agreement.conversion" value="785"/>
								<selectoption description="Agreement.courrierGenius" value="289"/>
								<selectoption description="Agreement.dateConditionsGenerales" value="1208"/>
								<selectoption description="Agreement.dateCreationSituationContrat" value="179"/>
								<selectoption description="Agreement.dateDArchivage" value="217"/>
								<selectoption description="Agreement.dateDEcheancePrincipale" value="1207"/>
								<selectoption description="Agreement.dateDEffetPremiereSituation" value="210"/>
								<selectoption description="Agreement.dateDEffetSituationContrat" value="983"/>
								<selectoption description="Agreement.dateDeCreationPremierePolice" value="899"/>
								<selectoption description="Agreement.datePAVDDCRE" value="5"/>
								<selectoption description="Agreement.datePremierEffetRC" value="226"/>
								<selectoption description="Agreement.dateProchaineQuittanceTerme" value="144"/>
								<selectoption description="Agreement.dateReceptionDuCourrier" value="172"/>
								<selectoption description="Agreement.demandeComplete" value="663"/>
								<selectoption description="Agreement.dernierNumeroDOffre" value="980"/>
								<selectoption description="Agreement.dernierNumeroDePolice" value="976"/>
								<selectoption description="Agreement.derniereTransactionEffectuee" value="1000"/>
								<selectoption description="Agreement.deviseDuContrat" value="8"/>
								<selectoption description="Agreement.entite" value="1096"/>
								<selectoption description="Agreement.fractionnement" value="1"/>
								<selectoption description="Agreement.gestionnaire" value="720"/>
								<selectoption description="Agreement.heureCreationSituationDeContrat" value="1032"/>
								<selectoption description="Agreement.indiceDeRenouvellement" value="1036"/>
								<selectoption description="Agreement.joker" value="237"/>
								<selectoption description="Agreement.jokerBM" value="238"/>
								<selectoption description="Agreement.labellisation" value="9"/>
								<selectoption description="Agreement.langue" value="213"/>
								<selectoption description="Agreement.libelleParticulariteGestion" value="177"/>
								<selectoption description="Agreement.mentionIdProducteurDerogatoir" value="247"/>
								<selectoption description="Agreement.methodeDeGestion" value="168"/>
								<selectoption description="Agreement.modeDEncaissement" value="2"/>
								<selectoption description="Agreement.motifDemandeIncomplete" value="664"/>
								<selectoption description="Agreement.natureDeLEvolutionDuContrat" value="1262"/>
								<selectoption description="Agreement.nbreDePersonnesCieClient" value="281"/>
								<selectoption description="Agreement.nombreDeDeclenchementsPCX" value="180"/>
								<selectoption description="Agreement.numero" value="6"/>
								<selectoption description="Agreement.numeroConditionsGenerales" value="134"/>
								<selectoption description="Agreement.numeroDeCx" value="140"/>
								<selectoption description="Agreement.numeroDeDomiciliationBancaire" value="209"/>
								<selectoption description="Agreement.numeroDePolice" value="3"/>
								<selectoption description="Agreement.numeroDePoliceDeBase" value="174"/>
								<selectoption description="Agreement.numeroDeSituation" value="11"/>
								<selectoption description="Agreement.offreLieeAContrat" value="170"/>
								<selectoption description="Agreement.organisation" value="907"/>
								<selectoption description="Agreement.particulariteDeGestion1" value="219"/>
								<selectoption description="Agreement.particulariteDeGestion2" value="220"/>
								<selectoption description="Agreement.particulierCorporate" value="214"/>
								<selectoption description="Agreement.pcxCx" value="139"/>
								<selectoption description="Agreement.policeDeTypeMarsh" value="960"/>
								<selectoption description="Agreement.policeProvientDUneAutreCompagnie" value="279"/>
								<selectoption description="Agreement.referencePreneur" value="661"/>
								<selectoption description="Agreement.referenceProducteur" value="662"/>
								<selectoption description="Agreement.saphir" value="790"/>
								<selectoption description="Agreement.sousAgentLaPoste" value="900"/>
								<selectoption description="Agreement.statutDeLOffre" value="1300"/>
								<selectoption description="Agreement.typeDeContrat" value="1282"/>
								<selectoption description="Agreement.typeDePolice" value="194"/>
								<selectoption description="Agreement.typeDePoliceDeBase" value="173"/>
								<selectoption description="Agreement.typeDeSousAgentLaPoste" value="286"/>
								<selectoption description="AgreementConnexity.entite" value="1115"/>
								<selectoption description="AgreementConnexity.motif" value="711"/>
								<selectoption description="AgreementConnexity.policeConnexe" value="787"/>
								<selectoption description="AgreementPremiumCalculation.coutsDePolice" value="831"/>
								<selectoption description="AgreementPremiumCalculation.dateDeDebut" value="911"/>
								<selectoption description="AgreementPremiumCalculation.dateDeFin" value="912"/>
								<selectoption description="AgreementPremiumCalculation.primeAPayer" value="830"/>
								<selectoption description="AgreementPremiumCalculation.primeCommerciale" value="826"/>
								<selectoption description="AgreementPremiumCalculation.primeTotale" value="910"/>
								<selectoption description="AgreementPremiumCalculation.scalingFactor" value="913"/>
								<selectoption description="AgreementPremiumCalculation.utilisePrimeDeBaseStockee" value="914"/>
								<selectoption description="AgreementProcessingInfo.macroEcranSousTypeDeTransaction" value="1031"/>
								<selectoption description="AntecedentAccident.accidentEnHebriete" value="1023"/>
								<selectoption description="AntecedentAccident.assureInfirme" value="1022"/>
								<selectoption description="AntecedentAccident.entite" value="1125"/>
								<selectoption description="AntecedentAccident.preneurDejaAssure" value="1019"/>
								<selectoption description="AntecedentAccident.resiliationCompagnie" value="1020"/>
								<selectoption description="AntecedentAccident.responsabiliteDejaEngagee" value="1021"/>
								<selectoption description="AntecedentFireNew.aDesCavesCatNat" value="1260"/>
								<selectoption description="AntecedentFireNew.annexesCatNat" value="1016"/>
								<selectoption description="AntecedentFireNew.appartementALEtageCatNat" value="1015"/>
								<selectoption description="AntecedentFireNew.dommageCavesUniquementCatNat" value="1018"/>
								<selectoption description="AntecedentFireNew.entite" value="1124"/>
								<selectoption description="AntecedentFireNew.innondationsDepuis5AnsCatNat" value="1017"/>
								<selectoption description="AntecedentFireNew.preneurDejaAssure" value="1009"/>
								<selectoption description="AntecedentFireNew.preneurDejaAssureRC" value="1012"/>
								<selectoption description="AntecedentFireNew.resiliationCompagnie" value="1010"/>
								<selectoption description="AntecedentFireNew.resiliationCompagnieRC" value="1013"/>
								<selectoption description="AntecedentFireNew.responsabiliteDejaEngageeRC" value="1014"/>
								<selectoption description="AntecedentFireNew.sinistreDepuis5Ans" value="1011"/>
								<selectoption description="AntecedentFireNew.sinistreDepuis5AnsRC" value="1206"/>
								<selectoption description="AntecedentFireOld.entite" value="1123"/>
								<selectoption description="AntecedentFireOld.preneurDejaAssure" value="1001"/>
								<selectoption description="AntecedentFireOld.preneurDejaAssureRC" value="1006"/>
								<selectoption description="AntecedentFireOld.resiliationCompagnie" value="1002"/>
								<selectoption description="AntecedentFireOld.resiliationCompagnieRC" value="1007"/>
								<selectoption description="AntecedentFireOld.responsabiliteDejaEngageeRC" value="1008"/>
								<selectoption description="AntecedentFireOld.sinistreDepuis5Ans" value="1005"/>
								<selectoption description="AntecedentFireOld.sinistreDepuis5AnsRC" value="1205"/>
								<selectoption description="AntecedentVehicle.conducteurContratPrecedentAnnule" value="702"/>
								<selectoption description="AntecedentVehicle.conducteurHandicapMaladie" value="701"/>
								<selectoption description="AntecedentVehicle.conducteurSinistreAvecDelit" value="703"/>
								<selectoption description="AntecedentVehicle.conducteurSinistreEnTort" value="704"/>
								<selectoption description="AntecedentVehicle.entite" value="1126"/>
								<selectoption description="AntecedentVehicle.preneurAntecedents" value="705"/>
								<selectoption description="AntecedentVehicle.preneurContratPrecedentAnnule" value="706"/>
								<selectoption description="AntecedentVehicle.preneurSinistreEnTort" value="707"/>
								<selectoption description="Antecedents.entite" value="1122"/>
								<selectoption description="Broker.codeRegion3" value="1039"/>
								<selectoption description="Broker.compagnieComptable" value="63"/>
								<selectoption description="Broker.compteProducteurCibleDuTransfert" value="819"/>
								<selectoption description="Broker.dateDuTransfertGlobal" value="818"/>
								<selectoption description="Broker.delegationDePouvoir" value="905"/>
								<selectoption description="Broker.entite" value="1097"/>
								<selectoption description="Broker.information" value="1060"/>
								<selectoption description="Broker.information[10]" value="721"/>
								<selectoption description="Broker.information[1]" value="1051"/>
								<selectoption description="Broker.information[2]" value="1052"/>
								<selectoption description="Broker.information[3]" value="1053"/>
								<selectoption description="Broker.information[4]" value="1054"/>
								<selectoption description="Broker.information[5]" value="1055"/>
								<selectoption description="Broker.information[6]" value="1056"/>
								<selectoption description="Broker.information[7]" value="1057"/>
								<selectoption description="Broker.information[8]" value="1058"/>
								<selectoption description="Broker.information[9]" value="1059"/>
								<selectoption description="Broker.marque" value="62"/>
								<selectoption description="Broker.modeDEncaissementBranche" value="1093"/>
								<selectoption description="Broker.modeDEncaissementGeneral" value="872"/>
								<selectoption description="Broker.natureDuCompte" value="897"/>
								<selectoption description="Broker.niveauDAutorisation" value="1220"/>
								<selectoption description="Broker.numeroDeCompteProducteur" value="59"/>
								<selectoption description="Broker.particularite" value="898"/>
								<selectoption description="Broker.particularite2" value="962"/>
								<selectoption description="Broker.particulariteBranche" value="906"/>
								<selectoption description="Broker.reductionPrimeMaximumSurGarantieParSituation" value="1219"/>
								<selectoption description="Broker.region" value="61"/>
								<selectoption description="Broker.scoring" value="1038"/>
								<selectoption description="BrokerHabilitation.bonusMalus" value="1242"/>
								<selectoption description="BrokerHabilitation.degressiviteAgreePV" value="1245"/>
								<selectoption description="BrokerHabilitation.effetDiffere" value="1247"/>
								<selectoption description="BrokerHabilitation.franchiseVolConducteur" value="1246"/>
								<selectoption description="BrokerHabilitation.retroactiviteFire" value="1249"/>
								<selectoption description="BrokerHabilitation.retroactiviteLiability" value="1248"/>
								<selectoption description="BrokerHabilitation.retroactivitePV" value="1241"/>
								<selectoption description="BrokerHabilitation.retroactiviteRC" value="1240"/>
								<selectoption description="BrokerHabilitation.valeurCatalogueAssureNeuf" value="1243"/>
								<selectoption description="BrokerHabilitation.valeurCatalogueAssureOccasion" value="1244"/>
								<selectoption description="BrokerHabilitation.valeurScoring" value="1239"/>
								<selectoption description="ClaimAntecedent.date" value="708"/>
								<selectoption description="ClaimAntecedent.entite" value="1114"/>
								<selectoption description="ClaimAntecedent.montant" value="710"/>
								<selectoption description="ClaimAntecedent.numeroGarantie" value="709"/>
								<selectoption description="Claims.date" value="677"/>
								<selectoption description="Claims.dateDebutRecuperationFranchise" value="681"/>
								<selectoption description="Claims.dateFinRecuperationFranchise" value="682"/>
								<selectoption description="Claims.degats" value="678"/>
								<selectoption description="Claims.entite" value="1112"/>
								<selectoption description="Claims.etatDuDossier" value="680"/>
								<selectoption description="Claims.numero" value="675"/>
								<selectoption description="Claims.particularite" value="679"/>
								<selectoption description="Claims.referenceDuGestionnaire" value="676"/>
								<selectoption description="ClauseDescription.entite" value="1209"/>
								<selectoption description="ClauseDescription.libelleLibre" value="698"/>
								<selectoption description="ClauseDescription.libelleLong" value="700"/>
								<selectoption description="ClauseDescription.numeroDeClause" value="697"/>
								<selectoption description="CommissionCoveragePeriodRelease.montantDeLaCommission" value="817"/>
								<selectoption description="CommissionCoveragePeriodRelease.numeroDeCompteProducteur" value="815"/>
								<selectoption description="CommissionCoveragePeriodRelease.typeDExploitation" value="1026"/>
								<selectoption description="CommissionCoveragePeriodRelease.typeDeCommission" value="816"/>
								<selectoption description="CommissionCoveragePeriodRelease.typeDeCompteProducteur" value="814"/>
								<selectoption description="CompetitorCompany.dateDEffet" value="695"/>
								<selectoption description="CompetitorCompany.dateDeFin" value="696"/>
								<selectoption description="CompetitorCompany.entite" value="1113"/>
								<selectoption description="CompetitorCompany.identiteDeLaCompagnie" value="692"/>
								<selectoption description="CompetitorCompany.montantDeLaPrime" value="694"/>
								<selectoption description="CompetitorCompany.numeroDePoliceConcurrente" value="693"/>
								<selectoption description="CompetitorCompany.typeDeConcurrence" value="691"/>
								<selectoption description="CompetitorCompanySubPeriod.resultat" value="954"/>
								<selectoption description="ComplementaryDescription.dateDEffet" value="278"/>
								<selectoption description="ComplementaryDescription.dateDeFin" value="277"/>
								<selectoption description="ComplementaryDescription.libelle" value="276"/>
								<selectoption description="ComplementaryDescription.numero" value="275"/>
								<selectoption description="Cost.dateDEffet" value="89"/>
								<selectoption description="Cost.dateDeFin" value="90"/>
								<selectoption description="Cost.entite" value="1098"/>
								<selectoption description="Cost.exoneration" value="91"/>
								<selectoption description="Cost.intervention" value="92"/>
								<selectoption description="Cost.qualificatifDeLaValeur" value="94"/>
								<selectoption description="Cost.typeDExploitation" value="188"/>
								<selectoption description="Cost.typeDeChargement" value="93"/>
								<selectoption description="Cost.valeur" value="95"/>
								<selectoption description="CostPeriod.dateDeDebut" value="964"/>
								<selectoption description="CostPeriod.dateDeFin" value="965"/>
								<selectoption description="CostPeriod.exoneration" value="967"/>
								<selectoption description="CostPeriod.intervention" value="966"/>
								<selectoption description="CostPeriod.ordre" value="861"/>
								<selectoption description="CostPeriod.qualificatifDeLaValeur" value="856"/>
								<selectoption description="CostPeriod.resultat" value="860"/>
								<selectoption description="CostPeriod.typeDeChargement" value="855"/>
								<selectoption description="CostPeriod.valeur" value="854"/>
								<selectoption description="CostTotalsForAgreement.chargementTotal" value="836"/>
								<selectoption description="CostTotalsForAgreement.typeDeChargement" value="835"/>
								<selectoption description="Coverage.categorie" value="1024"/>
								<selectoption description="Coverage.categorieSousCategorie" value="143"/>
								<selectoption description="Coverage.compagnieDeGestion" value="162"/>
								<selectoption description="Coverage.dateDEffet" value="14"/>
								<selectoption description="Coverage.dateDExpiration" value="158"/>
								<selectoption description="Coverage.dateDeFin" value="16"/>
								<selectoption description="Coverage.dateDeFinDeGratuite" value="17"/>
								<selectoption description="Coverage.dateDuTarifApplique" value="21"/>
								<selectoption description="Coverage.dureeDeReconductionTacite" value="133"/>
								<selectoption description="Coverage.dureeInitiale" value="157"/>
								<selectoption description="Coverage.emissionPrimeManuelle" value="159"/>
								<selectoption description="Coverage.entite" value="1099"/>
								<selectoption description="Coverage.etatCPCompagnie" value="142"/>
								<selectoption description="Coverage.garantieBloquee" value="1250"/>
								<selectoption description="Coverage.groupeAssistance" value="205"/>
								<selectoption description="Coverage.groupeDeReassurance" value="141"/>
								<selectoption description="Coverage.hausseTarifaire" value="163"/>
								<selectoption description="Coverage.indiceDeBlocage" value="136"/>
								<selectoption description="Coverage.libelleComplementaireAuxCodesOrigineSituation" value="155"/>
								<selectoption description="Coverage.motifFinDeGarantie" value="132"/>
								<selectoption description="Coverage.motifGratuite" value="131"/>
								<selectoption description="Coverage.nombreDePersonnes" value="304"/>
								<selectoption description="Coverage.nombreDeVehicules" value="206"/>
								<selectoption description="Coverage.numeroDeGarantie" value="22"/>
								<selectoption description="Coverage.origineSituation1" value="152"/>
								<selectoption description="Coverage.origineSituation2" value="153"/>
								<selectoption description="Coverage.origineSituation3" value="154"/>
								<selectoption description="Coverage.primeProvisionnelle" value="138"/>
								<selectoption description="Coverage.situationDepasseePourQuittance" value="161"/>
								<selectoption description="Coverage.sousCategorie" value="1025"/>
								<selectoption description="Coverage.tarificationManuelle" value="20"/>
								<selectoption description="Coverage.tauxApplique" value="160"/>
								<selectoption description="Coverage.tauxDeBaseAnnuel" value="137"/>
								<selectoption description="Coverage.typeDIndex" value="18"/>
								<selectoption description="Coverage.valeurDeLIndexALaSouscription" value="19"/>
								<selectoption description="CoverageOption.arrondiFranchise" value="186"/>
								<selectoption description="CoverageOption.dateDEffet" value="27"/>
								<selectoption description="CoverageOption.dateDeFin" value="28"/>
								<selectoption description="CoverageOption.detailALaCarte" value="187"/>
								<selectoption description="CoverageOption.entite" value="1100"/>
								<selectoption description="CoverageOption.fractionnement" value="1175"/>
								<selectoption description="CoverageOption.indexDeDepart" value="68"/>
								<selectoption description="CoverageOption.numeroDOption" value="23"/>
								<selectoption description="CoverageOption.qualificatifDeLaValeur" value="25"/>
								<selectoption description="CoverageOption.resultat" value="185"/>
								<selectoption description="CoverageOption.typeDIndexation" value="67"/>
								<selectoption description="CoverageOption.typeDOption" value="24"/>
								<selectoption description="CoverageOption.valeur" value="26"/>
								<selectoption description="CoveragePeriodRelease.dateDEffet" value="803"/>
								<selectoption description="CoveragePeriodRelease.dateDeFin" value="804"/>
								<selectoption description="CoveragePeriodRelease.numeroDeGarantie" value="802"/>
								<selectoption description="CoveragePeriodRelease.primeNetteTotale" value="805"/>
								<selectoption description="CoveragePeriodRelease.typeDIndexation" value="806"/>
								<selectoption description="CoveragePeriodRelease.typeDePersonnalisation" value="808"/>
								<selectoption description="CoveragePeriodRelease.valeurDeLIndex" value="807"/>
								<selectoption description="CoveragePeriodRelease.valeurDePersonnalisation" value="809"/>
								<selectoption description="CoveragePremiumCalculationPeriod.dateDeDebut" value="845"/>
								<selectoption description="CoveragePremiumCalculationPeriod.dateDeFin" value="846"/>
								<selectoption description="CoveragePremiumCalculationPeriod.dateDeReferenceChargementsCie" value="915"/>
								<selectoption description="CoveragePremiumCalculationPeriod.dateDeReferenceChargementsLegaux" value="916"/>
								<selectoption description="CoveragePremiumCalculationPeriod.dateDeReferenceIndex" value="842"/>
								<selectoption description="CoveragePremiumCalculationPeriod.dateDuTarifApplique" value="922"/>
								<selectoption description="CoveragePremiumCalculationPeriod.flagDeCalcul" value="979"/>
								<selectoption description="CoveragePremiumCalculationPeriod.indexDerogatoire" value="843"/>
								<selectoption description="CoveragePremiumCalculationPeriod.indexPeriodeCalcul" value="844"/>
								<selectoption description="CoveragePremiumCalculationPeriod.montantDeBaseDeLaCommissionIndexee" value="901"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primeCommerciale" value="838"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primeDeBase" value="840"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primeDeBaseAnnuelle" value="837"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primeIntermediaire" value="920"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primeMinimaleBT" value="919"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primePureReelle" value="921"/>
								<selectoption description="CoveragePremiumCalculationPeriod.primeTotale" value="839"/>
								<selectoption description="CoveragePremiumCalculationPeriod.tarifPrimeDeBaseManuel" value="923"/>
								<selectoption description="CoveragePremiumCalculationPeriod.totalDeChargementsCompagnie" value="917"/>
								<selectoption description="CoveragePremiumCalculationPeriod.totalDeChargementsLegaux" value="918"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.dateDeDebut" value="863"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.dateDeFin" value="864"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.montantDeBaseDeLaCommissionIndexee" value="1302"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.primeCommerciale" value="868"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.primeDeBase" value="862"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.primeIntermediaire" value="871"/>
								<selectoption description="CoveragePremiumCalculationSubPeriod.prorata" value="867"/>
								<selectoption description="EvaluationGrid.codePostal" value="1004"/>
								<selectoption description="EvaluationGrid.critere" value="765"/>
								<selectoption description="EvaluationGrid.entite" value="1119"/>
								<selectoption description="EvaluationGrid.nombre" value="766"/>
								<selectoption description="EvaluationGrid.nombreDEmplacementVoiture" value="988"/>
								<selectoption description="EvaluationGrid.nombreDeBureau" value="990"/>
								<selectoption description="EvaluationGrid.nombreDeCave" value="986"/>
								<selectoption description="EvaluationGrid.nombreDeChambre" value="989"/>
								<selectoption description="EvaluationGrid.nombreDeGarage" value="987"/>
								<selectoption description="EvaluationGrid.nombreDeGrenier" value="999"/>
								<selectoption description="EvaluationGrid.nombreDeLiving" value="984"/>
								<selectoption description="EvaluationGrid.nombreDePieceAutre" value="991"/>
								<selectoption description="EvaluationGrid.nombreDeSalleDeBain" value="985"/>
								<selectoption description="EvaluationGrid.nombreDeVeranda" value="1003"/>
								<selectoption description="EvaluationGrid.plafondHaut" value="993"/>
								<selectoption description="EvaluationGrid.plusDUneSalleDeBain" value="992"/>
								<selectoption description="EvaluationGrid.presenceAscensseur" value="995"/>
								<selectoption description="EvaluationGrid.quatreFacade" value="996"/>
								<selectoption description="EvaluationGrid.rangeeCinqMetres" value="998"/>
								<selectoption description="EvaluationGrid.solPierreNature" value="994"/>
								<selectoption description="EvaluationGrid.toitureMateriauxNobles" value="1040"/>
								<selectoption description="Fire.adresseDuRisque" value="738"/>
								<selectoption description="Fire.calculDuCapital" value="755"/>
								<selectoption description="Fire.capitalContenant" value="732"/>
								<selectoption description="Fire.capitalContenu" value="733"/>
								<selectoption description="Fire.capitalDeReferenceVolumeIdeal" value="740"/>
								<selectoption description="Fire.classeDuRisque" value="728"/>
								<selectoption description="Fire.contiguite" value="731"/>
								<selectoption description="Fire.dateDeNaissance" value="754"/>
								<selectoption description="Fire.dateDeReceptionDesTravaux" value="752"/>
								<selectoption description="Fire.entite" value="1116"/>
								<selectoption description="Fire.libelleParticulariteGestion" value="745"/>
								<selectoption description="Fire.loyerAnnuelChargesInclues" value="741"/>
								<selectoption description="Fire.montantLimiteDIndemnite" value="746"/>
								<selectoption description="Fire.nombreDeBatiments" value="756"/>
								<selectoption description="Fire.nombreDeLogements" value="734"/>
								<selectoption description="Fire.nombreDePieces" value="727"/>
								<selectoption description="Fire.nombreDeRisques" value="739"/>
								<selectoption description="Fire.nombreDeTranches" value="750"/>
								<selectoption description="Fire.nombreDeVehicules" value="747"/>
								<selectoption description="Fire.nouvelleConstruction" value="751"/>
								<selectoption description="Fire.occupationDuRisque" value="730"/>
								<selectoption description="Fire.particularitesGestion" value="1084"/>
								<selectoption description="Fire.particularitesGestion[1]" value="1082"/>
								<selectoption description="Fire.particularitesGestion[2]" value="744"/>
								<selectoption description="Fire.preventionVol" value="753"/>
								<selectoption description="Fire.qualiteDuProprietaireDuBatiment" value="729"/>
								<selectoption description="Fire.score" value="748"/>
								<selectoption description="Fire.superficie" value="742"/>
								<selectoption description="Fire.typeDHabitation" value="724"/>
								<selectoption description="Fire.typeDeConstruction" value="735"/>
								<selectoption description="Fire.typeDeCouvertureContenant" value="737"/>
								<selectoption description="Fire.typeDeCouvertureContenu" value="736"/>
								<selectoption description="Fire.typeDeFinition" value="726"/>
								<selectoption description="Fire.typeDeFormule" value="743"/>
								<selectoption description="Fire.typeDeGrille" value="725"/>
								<selectoption description="Fire.typeDeTranche" value="749"/>
								<selectoption description="Fleet.blocageHausseTarifaire" value="973"/>
								<selectoption description="Fleet.clause" value="1050"/>
								<selectoption description="Fleet.clause[1]" value="1041"/>
								<selectoption description="Fleet.clause[2]" value="1042"/>
								<selectoption description="Fleet.clause[3]" value="1043"/>
								<selectoption description="Fleet.clause[4]" value="331"/>
								<selectoption description="Fleet.codePostal" value="718"/>
								<selectoption description="Fleet.compagnie" value="332"/>
								<selectoption description="Fleet.compteFinancier" value="321"/>
								<selectoption description="Fleet.dateDAssainissement" value="326"/>
								<selectoption description="Fleet.dateDeDerniereModification" value="315"/>
								<selectoption description="Fleet.dateDeFin" value="719"/>
								<selectoption description="Fleet.dateIntroductionParticulierCorporate" value="314"/>
								<selectoption description="Fleet.demandeDAffiliationGenius" value="318"/>
								<selectoption description="Fleet.demandeDeMailingGenius" value="316"/>
								<selectoption description="Fleet.intitule" value="308"/>
								<selectoption description="Fleet.libelleComplementaire" value="309"/>
								<selectoption description="Fleet.libelleLibreGarantie" value="1070"/>
								<selectoption description="Fleet.libelleLibreGarantie[10]" value="329"/>
								<selectoption description="Fleet.libelleLibreGarantie[1]" value="1061"/>
								<selectoption description="Fleet.libelleLibreGarantie[2]" value="1062"/>
								<selectoption description="Fleet.libelleLibreGarantie[3]" value="1063"/>
								<selectoption description="Fleet.libelleLibreGarantie[4]" value="1064"/>
								<selectoption description="Fleet.libelleLibreGarantie[5]" value="1065"/>
								<selectoption description="Fleet.libelleLibreGarantie[6]" value="1066"/>
								<selectoption description="Fleet.libelleLibreGarantie[7]" value="1067"/>
								<selectoption description="Fleet.libelleLibreGarantie[8]" value="1068"/>
								<selectoption description="Fleet.libelleLibreGarantie[9]" value="1069"/>
								<selectoption description="Fleet.memoDAssainissement" value="327"/>
								<selectoption description="Fleet.nomPersonneDeContact" value="322"/>
								<selectoption description="Fleet.nombreDePersonnes" value="317"/>
								<selectoption description="Fleet.numeroDeRegroupement" value="606"/>
								<selectoption description="Fleet.numeroFormuleSimple" value="311"/>
								<selectoption description="Fleet.numeroGrandCompte" value="310"/>
								<selectoption description="Fleet.organisation" value="313"/>
								<selectoption description="Fleet.particulierCorporate" value="312"/>
								<selectoption description="Fleet.produit" value="717"/>
								<selectoption description="Fleet.regionDeGestionSinistre" value="320"/>
								<selectoption description="Fleet.statut" value="716"/>
								<selectoption description="Fleet.type" value="328"/>
								<selectoption description="Fleet.type" value="610"/>
								<selectoption description="Fleet.typeDAssainissement" value="325"/>
								<selectoption description="Fleet.typeDeDestinataireGenius" value="319"/>
								<selectoption description="Fleet.typeDeGestion" value="323"/>
								<selectoption description="Fleet.typeDeRegroupement" value="604"/>
								<selectoption description="Fleet.useridGestionnaireDeModification" value="324"/>
								<selectoption description="GlobalRelease.dedoublement" value="887"/>
								<selectoption description="GlobalRelease.marque" value="894"/>
								<selectoption description="GlobalRelease.modele" value="895"/>
								<selectoption description="GlobalRelease.ordreQuittanceGlobale" value="884"/>
								<selectoption description="GlobalRelease.ordreQuittanceGlobaleDedoublee" value="889"/>
								<selectoption description="GlobalRelease.plaque" value="893"/>
								<selectoption description="GlobalRelease.policeMere" value="882"/>
								<selectoption description="GlobalRelease.quittanceAnnulee" value="891"/>
								<selectoption description="GlobalRelease.quittanceGlobale" value="883"/>
								<selectoption description="GlobalRelease.quittanceGlobaleDedoublee" value="888"/>
								<selectoption description="GlobalRelease.reglobalisation" value="890"/>
								<selectoption description="GlobalRelease.sequenceDetailQuittanceGlobale" value="886"/>
								<selectoption description="GlobalRelease.situationContractuelle" value="885"/>
								<selectoption description="GlobalRelease.typeDePlaque" value="892"/>
								<selectoption description="GlobalRelease.version" value="896"/>
								<selectoption description="Index.dateDEffet" value="822"/>
								<selectoption description="Index.dateDeFin" value="823"/>
								<selectoption description="Index.entite" value="1121"/>
								<selectoption description="Index.typeDIndex" value="821"/>
								<selectoption description="Index.valeur" value="824"/>
								<selectoption description="InsurableObject.entite" value="1107"/>
								<selectoption description="InsurableObject.numeroDeReferenceRisquePrincipal" value="904"/>
								<selectoption description="InsurableObject.numeroDeSequenceDuRisque" value="225"/>
								<selectoption description="LegalCostCoveragePeriodRelease.chargementManuel" value="812"/>
								<selectoption description="LegalCostCoveragePeriodRelease.exonerationDuChargement" value="813"/>
								<selectoption description="LegalCostCoveragePeriodRelease.montant" value="811"/>
								<selectoption description="LegalCostCoveragePeriodRelease.type" value="810"/>
								<selectoption description="MainDriver.aDesEnfants" value="712"/>
								<selectoption description="MainDriver.entite" value="1101"/>
								<selectoption description="MainDriver.etatStageDeConduite" value="621"/>
								<selectoption description="MainDriver.parentsAssuresChezAXA" value="58"/>
								<selectoption description="MainDriver.suiviStageDeConduite" value="69"/>
								<selectoption description="MainDriver.tarifJeuneConducteur" value="1301"/>
								<selectoption description="MajorationReduction.dateDEffet" value="296"/>
								<selectoption description="MajorationReduction.dateDeFin" value="295"/>
								<selectoption description="MajorationReduction.derogeAuxDatesGarantie" value="1037"/>
								<selectoption description="MajorationReduction.indexation" value="80"/>
								<selectoption description="MajorationReduction.indiceDeBlocage" value="292"/>
								<selectoption description="MajorationReduction.libelleLibre" value="294"/>
								<selectoption description="MajorationReduction.libelleLong" value="699"/>
								<selectoption description="MajorationReduction.numeroDOrdreDAppel" value="307"/>
								<selectoption description="MajorationReduction.numeroDeMajorationReduction" value="297"/>
								<selectoption description="MajorationReduction.qualificatifDeLaValeur" value="81"/>
								<selectoption description="MajorationReduction.qualificatifMajorationReduction" value="97"/>
								<selectoption description="MajorationReduction.resultatDuCalcul" value="103"/>
								<selectoption description="MajorationReduction.tarificationManuelle" value="293"/>
								<selectoption description="MajorationReduction.valeur" value="84"/>
								<selectoption description="MajorationReductionPeriod.resultat" value="853"/>
								<selectoption description="MajorationReductionSubPeriod.numeroDeSequence" value="971"/>
								<selectoption description="MajorationReductionSubPeriod.resultat" value="955"/>
								<selectoption description="MajorationReductionSubPeriod.typeDeDerogation" value="969"/>
								<selectoption description="MajorationReductionSubPeriod.typeDePrime" value="970"/>
								<selectoption description="Operation.application" value="655"/>
								<selectoption description="Operation.ecran" value="788"/>
								<selectoption description="Operation.statutDuCopy" value="616"/>
								<selectoption description="Operation.texteLibre" value="789"/>
								<selectoption description="Operation.transaction" value="622"/>
								<selectoption description="Operation.typeDeFrontEnd" value="1280"/>
								<selectoption description="Operation.typeDeMouvement" value="623"/>
								<selectoption description="Operation.typeDeMouvement" value="628"/>
								<selectoption description="Operation.typeDeTransactionAXALink" value="1281"/>
								<selectoption description="Organisation.appellation" value="1299"/>
								<selectoption description="Organisation.numeroDEntreprise" value="261"/>
								<selectoption description="Organisation.numeroDeTVA" value="1034"/>
								<selectoption description="Organisation.organisation" value="280"/>
								<selectoption description="ParkingAddress.codePostal" value="763"/>
								<selectoption description="ParkingAddress.entite" value="1118"/>
								<selectoption description="ParkingAddress.lettreDernierNumero" value="1204"/>
								<selectoption description="ParkingAddress.localite" value="762"/>
								<selectoption description="ParkingAddress.numero" value="1203"/>
								<selectoption description="ParkingAddress.numeroBoite" value="1202"/>
								<selectoption description="ParkingAddress.pays" value="764"/>
								<selectoption description="ParkingAddress.rue" value="761"/>
								<selectoption description="PartialSegmentationCoefficientPeriod.nom" value="981"/>
								<selectoption description="PartialSegmentationCoefficientPeriod.sequence" value="982"/>
								<selectoption description="PartialSegmentationCoefficientPeriod.valeur" value="1176"/>
								<selectoption description="Party.Genre" value="66"/>
								<selectoption description="Party.accordDirectMarketing" value="169"/>
								<selectoption description="Party.dateDEffet" value="248"/>
								<selectoption description="Party.dateDeFin" value="249"/>
								<selectoption description="Party.entite" value="1108"/>
								<selectoption description="Party.flagTVAAPayer" value="260"/>
								<selectoption description="Party.historique" value="290"/>
								<selectoption description="Party.langue" value="250"/>
								<selectoption description="Party.nom" value="264"/>
								<selectoption description="Party.numeroCIF" value="256"/>
								<selectoption description="Party.numeroDeClient" value="262"/>
								<selectoption description="PartyRole.affinity" value="101"/>
								<selectoption description="PartyRole.codeParentSouscriptionConducteur" value="1048"/>
								<selectoption description="PartyRole.codeParentSouscriptionConducteur[1]" value="1044"/>
								<selectoption description="PartyRole.codeParentSouscriptionConducteur[2]" value="1045"/>
								<selectoption description="PartyRole.codeParentSouscriptionConducteur[3]" value="1046"/>
								<selectoption description="PartyRole.codeParentSouscriptionConducteur[4]" value="1047"/>
								<selectoption description="PartyRole.codeParentSouscriptionConducteur[5]" value="1035"/>
								<selectoption description="PartyRole.entite" value="1102"/>
								<selectoption description="PartyRole.fonction" value="723"/>
								<selectoption description="PartyRole.fonctionCourrier" value="263"/>
								<selectoption description="PeriodRelease.chargesTotales" value="799"/>
								<selectoption description="PeriodRelease.commissionTotale" value="801"/>
								<selectoption description="PeriodRelease.dateDeDebut" value="795"/>
								<selectoption description="PeriodRelease.dateDeFin" value="796"/>
								<selectoption description="PeriodRelease.numeroDeFormule" value="794"/>
								<selectoption description="PeriodRelease.numeroDeSequence" value="792"/>
								<selectoption description="PeriodRelease.numeroDeSequenceDuRisque" value="793"/>
								<selectoption description="PeriodRelease.primeNetteTotale" value="798"/>
								<selectoption description="PeriodRelease.primeTotale" value="800"/>
								<selectoption description="PeriodRelease.typeDePeriode" value="797"/>
								<selectoption description="Person.categorieDePermisDeConduire" value="252"/>
								<selectoption description="Person.dateDeNaissance" value="54"/>
								<selectoption description="Person.dateDePermisDeConduire" value="64"/>
								<selectoption description="Person.entite" value="1095"/>
								<selectoption description="Person.nationalite" value="251"/>
								<selectoption description="Person.numeroNational" value="273"/>
								<selectoption description="Person.prefixe" value="254"/>
								<selectoption description="Person.prefixeTexteLibre" value="255"/>
								<selectoption description="Person.prenom" value="265"/>
								<selectoption description="Person.profession" value="56"/>
								<selectoption description="Person.sexe" value="55"/>
								<selectoption description="Person.typeConjoint" value="274"/>
								<selectoption description="Personalisation.dateDEffet" value="72"/>
								<selectoption description="Personalisation.dateDeFin" value="73"/>
								<selectoption description="Personalisation.dateProchaineReevaluation" value="106"/>
								<selectoption description="Personalisation.degre" value="71"/>
								<selectoption description="Personalisation.entite" value="1110"/>
								<selectoption description="Personalisation.intervention" value="302"/>
								<selectoption description="Personalisation.motifIntervention" value="104"/>
								<selectoption description="Personalisation.referenceLieeALEvolution" value="105"/>
								<selectoption description="Personalisation.type" value="70"/>
								<selectoption description="PersonalisationPeriod.coefficient" value="943"/>
								<selectoption description="PersonalisationPeriod.coefficientDePersonnalisationGlobal" value="944"/>
								<selectoption description="PersonalisationPeriod.dateDeReference" value="945"/>
								<selectoption description="PersonalisationPeriod.pourcentage" value="942"/>
								<selectoption description="PolicyHolder.compteBancaire" value="175"/>
								<selectoption description="PolicyHolder.deductibiliteTVA" value="102"/>
								<selectoption description="PolicyHolder.entite" value="1109"/>
								<selectoption description="PolicyHolder.packageSouscrit" value="660"/>
								<selectoption description="PolicyHolder.plusDe5VehiculesAssures" value="659"/>
								<selectoption description="PolicyHolder.pourcentageProbaPerteClient" value="258"/>
								<selectoption description="PolicyHolder.scoreCampagneApprocheClient" value="259"/>
								<selectoption description="PolicyHolder.scoreClientNormal" value="257"/>
								<selectoption description="PostalAddress.boite" value="269"/>
								<selectoption description="PostalAddress.codePostal" value="53"/>
								<selectoption description="PostalAddress.entite" value="1103"/>
								<selectoption description="PostalAddress.lettreDerriereNumero" value="268"/>
								<selectoption description="PostalAddress.localite" value="272"/>
								<selectoption description="PostalAddress.numero" value="267"/>
								<selectoption description="PostalAddress.numeroBoite" value="270"/>
								<selectoption description="PostalAddress.pays" value="1094"/>
								<selectoption description="PostalAddress.pays" value="1133"/>
								<selectoption description="PostalAddress.rue" value="266"/>
								<selectoption description="Premium.entite" value="1104"/>
								<selectoption description="Premium.primeDeBase" value="30"/>
								<selectoption description="Premium.type" value="29"/>
								<selectoption description="PrintAgreement.conditionsGeneralesAJoindre" value="135"/>
								<selectoption description="PrintAgreement.destinatairesDocuments" value="149"/>
								<selectoption description="PrintAgreement.impressionCP" value="145"/>
								<selectoption description="PrintAgreement.impressionComptant" value="147"/>
								<selectoption description="PrintAgreement.impressionDocumentsSupplementaires" value="150"/>
								<selectoption description="PrintAgreement.nombreDExemplairesCP" value="146"/>
								<selectoption description="PrintAgreement.nombreDExemplairesComptant" value="148"/>
								<selectoption description="PrintAgreement.nombreDExemplairesDocumentsSupplementaires" value="151"/>
								<selectoption description="PrintAgreement.typeDeLettre" value="974"/>
								<selectoption description="Relation.type" value="1279"/>
								<selectoption description="Release.calculManuAuto" value="648"/>
								<selectoption description="Release.chargementTotal" value="647"/>
								<selectoption description="Release.coutPolice" value="650"/>
								<selectoption description="Release.coutQuittance" value="651"/>
								<selectoption description="Release.dateDeCreation" value="630"/>
								<selectoption description="Release.dateDeDebut" value="631"/>
								<selectoption description="Release.dateDeFin" value="632"/>
								<selectoption description="Release.dateDeLEtat" value="634"/>
								<selectoption description="Release.dateDuDernierQuittancement" value="978"/>
								<selectoption description="Release.dateLettreRecommandee" value="638"/>
								<selectoption description="Release.dernierNumeroQuittanceComptant" value="977"/>
								<selectoption description="Release.destinataireDeLImprime" value="975"/>
								<selectoption description="Release.destinataireDuComptant" value="641"/>
								<selectoption description="Release.devise" value="652"/>
								<selectoption description="Release.etat" value="633"/>
								<selectoption description="Release.impressionDocumentComptant" value="639"/>
								<selectoption description="Release.impressionDocumentsSupplementaires" value="653"/>
								<selectoption description="Release.libelleLibrePasDeComptant" value="642"/>
								<selectoption description="Release.modeDEncaissement" value="636"/>
								<selectoption description="Release.montant" value="637"/>
								<selectoption description="Release.montantPrimeNetteTotale" value="646"/>
								<selectoption description="Release.montantTotalCommissionProducteur" value="1075"/>
								<selectoption description="Release.montantTotalCommissionProducteur[1]" value="1071"/>
								<selectoption description="Release.montantTotalCommissionProducteur[2]" value="1072"/>
								<selectoption description="Release.montantTotalCommissionProducteur[3]" value="1073"/>
								<selectoption description="Release.montantTotalCommissionProducteur[4]" value="1074"/>
								<selectoption description="Release.montantTotalCommissionProducteur[5]" value="645"/>
								<selectoption description="Release.motifDAnnulation" value="635"/>
								<selectoption description="Release.nombreDExemplairesDocumentsSupplementaires" value="654"/>
								<selectoption description="Release.nombreExDocumentComptantSupplementaires" value="640"/>
								<selectoption description="Release.numero" value="625"/>
								<selectoption description="Release.numeroCompteProducteur" value="1080"/>
								<selectoption description="Release.numeroCompteProducteur[1]" value="1076"/>
								<selectoption description="Release.numeroCompteProducteur[2]" value="1077"/>
								<selectoption description="Release.numeroCompteProducteur[3]" value="1078"/>
								<selectoption description="Release.numeroCompteProducteur[4]" value="1079"/>
								<selectoption description="Release.numeroCompteProducteur[5]" value="644"/>
								<selectoption description="Release.numeroDOrdre" value="626"/>
								<selectoption description="Release.numeroDeSequenceSituationContrat" value="627"/>
								<selectoption description="Release.pourcentageAppliqueSurCalculComptant" value="649"/>
								<selectoption description="Release.type" value="629"/>
								<selectoption description="Release.typeDeMouvement" value="1303"/>
								<selectoption description="Release.typeProducteur" value="1089"/>
								<selectoption description="Release.typeProducteur[1]" value="1085"/>
								<selectoption description="Release.typeProducteur[2]" value="1086"/>
								<selectoption description="Release.typeProducteur[3]" value="1087"/>
								<selectoption description="Release.typeProducteur[4]" value="1088"/>
								<selectoption description="Release.typeProducteur[5]" value="643"/>
								<selectoption description="ReleaseCalcul.batchExecute" value="881"/>
								<selectoption description="ReleaseCalcul.dateDEffet" value="876"/>
								<selectoption description="ReleaseCalcul.dateDeDemande" value="873"/>
								<selectoption description="ReleaseCalcul.dateDeFin" value="877"/>
								<selectoption description="ReleaseCalcul.heureDemande" value="880"/>
								<selectoption description="ReleaseCalcul.sequenceDeDemande" value="875"/>
								<selectoption description="ReleaseCalcul.typeDEncaissement" value="879"/>
								<selectoption description="ReleaseCalcul.typeDeCalcul" value="878"/>
								<selectoption description="ReleaseCalcul.typeDeDemande" value="874"/>
								<selectoption description="ResponsabilityCivil.classeDuRisque" value="778"/>
								<selectoption description="ResponsabilityCivil.qualiteAssurance" value="780"/>
								<selectoption description="ResponsabilityCivil.typeRC" value="1092"/>
								<selectoption description="ResponsabilityCivil.typeRC[1]" value="1090"/>
								<selectoption description="ResponsabilityCivil.typeRC[2]" value="1091"/>
								<selectoption description="ResponsabilityCivil.typeRC[3]" value="779"/>
								<selectoption description="ResponsabilitySingle.capitalUnique" value="784"/>
								<selectoption description="ResponsabilitySingle.classeDuRisque" value="781"/>
								<selectoption description="ResponsabilitySingle.nomBeneficiaire" value="782"/>
								<selectoption description="ResponsabilitySingle.typeDeCouverture" value="783"/>
								<selectoption description="RiskAddress.codePostal" value="759"/>
								<selectoption description="RiskAddress.entite" value="1117"/>
								<selectoption description="RiskAddress.lettreDernierNumero" value="1201"/>
								<selectoption description="RiskAddress.localite" value="758"/>
								<selectoption description="RiskAddress.numero" value="1200"/>
								<selectoption description="RiskAddress.numeroBoite" value="1199"/>
								<selectoption description="RiskAddress.pays" value="760"/>
								<selectoption description="RiskAddress.rue" value="757"/>
								<selectoption description="Segmentation.coefficientGlobalDeSegmentation" value="298"/>
								<selectoption description="Segmentation.coefficientImpose" value="110"/>
								<selectoption description="Segmentation.dateDEffet" value="619"/>
								<selectoption description="Segmentation.dateDeFin" value="620"/>
								<selectoption description="Segmentation.dateProchaineReevaluation" value="618"/>
								<selectoption description="Segmentation.degreDeSegmentation" value="107"/>
								<selectoption description="Segmentation.degreImpose" value="109"/>
								<selectoption description="Segmentation.intervention" value="228"/>
								<selectoption description="Segmentation.motifIntervention" value="229"/>
								<selectoption description="Segmentation.nombreDePoints" value="108"/>
								<selectoption description="Segmentation.nombreDePointsDeroges" value="112"/>
								<selectoption description="Segmentation.referenceLieeALEvolution" value="902"/>
								<selectoption description="Segmentation.tarifPlafonne" value="111"/>
								<selectoption description="Segmentation.type" value="227"/>
								<selectoption description="SegmentationCriterium.nom" value="232"/>
								<selectoption description="SegmentationCriterium.traitementDeLaValeur" value="115"/>
								<selectoption description="SegmentationCriterium.typeDeValeur" value="117"/>
								<selectoption description="SegmentationCriterium.valeur" value="233"/>
								<selectoption description="SegmentationCriteriumPeriod.modifiable" value="938"/>
								<selectoption description="SegmentationCriteriumPeriod.nom" value="935"/>
								<selectoption description="SegmentationCriteriumPeriod.sequence" value="941"/>
								<selectoption description="SegmentationCriteriumPeriod.traitementDeLaValeur" value="940"/>
								<selectoption description="SegmentationCriteriumPeriod.typeDeValeur" value="936"/>
								<selectoption description="SegmentationCriteriumPeriod.valeur" value="937"/>
								<selectoption description="SegmentationCriteriumPeriod.valeurParDefaut" value="939"/>
								<selectoption description="SegmentationPartial.entite" value="1259"/>
								<selectoption description="SegmentationPartial.nomCoefficientDetail" value="114"/>
								<selectoption description="SegmentationPartial.valeurCoefficientDetail" value="231"/>
								<selectoption description="SegmentationPeriod.coefficientDeSegmentationGlobal" value="929"/>
								<selectoption description="SegmentationPeriod.conservationDerogationPermanente" value="932"/>
								<selectoption description="SegmentationPeriod.conservationDerogationTemporaire" value="933"/>
								<selectoption description="SegmentationPeriod.dateDeReference" value="930"/>
								<selectoption description="SegmentationPeriod.intervention" value="968"/>
								<selectoption description="SegmentationPeriod.reactualisation" value="931"/>
								<selectoption description="Specification.entite" value="1105"/>
								<selectoption description="Specification.formule" value="12"/>
								<selectoption description="Specification.gamme" value="908"/>
								<selectoption description="Specification.label" value="909"/>
								<selectoption description="Specification.produit" value="96"/>
								<selectoption description="TariffAdjustementPeriod.dateDEffet" value="947"/>
								<selectoption description="TariffAdjustementPeriod.dateDeFin" value="951"/>
								<selectoption description="TariffAdjustementPeriod.dateDeTarification" value="946"/>
								<selectoption description="TariffAdjustementPeriod.qualificatifDeLaValeur" value="948"/>
								<selectoption description="TariffAdjustementPeriod.typeDePrime" value="950"/>
								<selectoption description="TariffAdjustementPeriod.valeur" value="949"/>
								<selectoption description="TariffAdjustment.dateDEffet" value="1304"/>
								<selectoption description="TariffAdjustment.dateDeFin" value="118"/>
								<selectoption description="TariffAdjustment.dateDeTarification" value="38"/>
								<selectoption description="TariffAdjustment.qualificatifDeLaValeur" value="78"/>
								<selectoption description="TariffAdjustment.typeDePrime" value="77"/>
								<selectoption description="TariffAdjustment.valeur" value="79"/>
								<selectoption description="TariffCommission.calculManuelAuto" value="124"/>
								<selectoption description="TariffCommission.dateDEffet" value="299"/>
								<selectoption description="TariffCommission.dateDeFin" value="300"/>
								<selectoption description="TariffCommission.montantDeBaseCommissionIndexee" value="301"/>
								<selectoption description="TariffCommission.numeroDeCompteProducteur" value="120"/>
								<selectoption description="TariffCommission.qualificatifDeLaCommissionIndexee" value="83"/>
								<selectoption description="TariffCommission.qualificatifDeLaRetrocessionIndexee" value="181"/>
								<selectoption description="TariffCommission.typeDeCommission" value="121"/>
								<selectoption description="TariffCommission.typeDeProducteur" value="119"/>
								<selectoption description="TariffCommission.typeDeRetrocessionIndexee" value="126"/>
								<selectoption description="TariffCommission.valeurDeLaCommissionIndexee" value="15"/>
								<selectoption description="TariffCommission.valeurDeLaRetrocessionIndexee" value="13"/>
								<selectoption description="TariffCommissionPeriod.resultatCommission" value="847"/>
								<selectoption description="TariffCommissionPeriod.resultatRetrocession" value="848"/>
								<selectoption description="TariffCommissionSubPeriod.resultatCommission" value="926"/>
								<selectoption description="TariffCommissionSubPeriod.resultatRetrocession" value="927"/>
								<selectoption description="TariffCommissionTotalsForAgreement.commissionTotale" value="833"/>
								<selectoption description="TariffCommissionTotalsForAgreement.numeroDeCompteProducteur" value="832"/>
								<selectoption description="TariffCommissionTotalsForAgreement.retrocessionTotale" value="834"/>
								<selectoption description="TariffIdentifier.dateRelease" value="959"/>
								<selectoption description="TariffIdentifier.gamme" value="956"/>
								<selectoption description="TariffIdentifier.label" value="957"/>
								<selectoption description="TariffIdentifier.produit" value="958"/>
								<selectoption description="ThirdPartyCompany.aperiteur" value="670"/>
								<selectoption description="ThirdPartyCompany.dateDEffet" value="76"/>
								<selectoption description="ThirdPartyCompany.dateDeFin" value="667"/>
								<selectoption description="ThirdPartyCompany.entite" value="1111"/>
								<selectoption description="ThirdPartyCompany.numeroDeCompagnieCreancier" value="672"/>
								<selectoption description="ThirdPartyCompany.numeroDePoliceCollective" value="669"/>
								<selectoption description="ThirdPartyCompany.policeCollective" value="668"/>
								<selectoption description="ThirdPartyCompany.referenceChezCompagnieCreancier" value="673"/>
								<selectoption description="ThirdPartyCompany.tauxDeRepartitionCoassurance" value="674"/>
								<selectoption description="ThirdPartyCompany.typeDIntervenant" value="671"/>
								<selectoption description="Vehicle.antivol" value="223"/>
								<selectoption description="Vehicle.carburant" value="42"/>
								<selectoption description="Vehicle.categorieDeTransport" value="34"/>
								<selectoption description="Vehicle.cylindree" value="31"/>
								<selectoption description="Vehicle.dateDAchat" value="130"/>
								<selectoption description="Vehicle.dateDeConstruction" value="190"/>
								<selectoption description="Vehicle.dateDePremiereMiseEnCirculation" value="50"/>
								<selectoption description="Vehicle.dateKilometrage" value="657"/>
								<selectoption description="Vehicle.entite" value="1106"/>
								<selectoption description="Vehicle.factureDAchat" value="236"/>
								<selectoption description="Vehicle.garageDeNuit" value="234"/>
								<selectoption description="Vehicle.genre" value="47"/>
								<selectoption description="Vehicle.kilometrage" value="656"/>
								<selectoption description="Vehicle.masseMaximaleAutorisee" value="51"/>
								<selectoption description="Vehicle.montantDuMobilophone" value="903"/>
								<selectoption description="Vehicle.nombreDAnneesDePossession" value="791"/>
								<selectoption description="Vehicle.nombreDAnneesSansSinistre" value="128"/>
								<selectoption description="Vehicle.nombreDePlaces" value="46"/>
								<selectoption description="Vehicle.nombreKmAParcourir" value="197"/>
								<selectoption description="Vehicle.numeroDeChassis" value="189"/>
								<selectoption description="Vehicle.numeroDePlaque1" value="191"/>
								<selectoption description="Vehicle.numeroDePlaque2" value="193"/>
								<selectoption description="Vehicle.particulariteDeGestionTexte" value="221"/>
								<selectoption description="Vehicle.poidsAVide" value="195"/>
								<selectoption description="Vehicle.pourcentageEcartValCatalogueValAssuree" value="196"/>
								<selectoption description="Vehicle.produitsDangereuxTransportes" value="45"/>
								<selectoption description="Vehicle.puissance" value="242"/>
								<selectoption description="Vehicle.traction" value="32"/>
								<selectoption description="Vehicle.type" value="49"/>
								<selectoption description="Vehicle.typeDeCirculation" value="224"/>
								<selectoption description="Vehicle.typeDePlaque1" value="37"/>
								<selectoption description="Vehicle.typeDePlaque2" value="192"/>
								<selectoption description="Vehicle.typeDeTarificationRemorque" value="52"/>
								<selectoption description="Vehicle.typeDeValorisation" value="199"/>
								<selectoption description="Vehicle.usage" value="48"/>
								<selectoption description="Vehicle.valeurAssuree" value="43"/>
								<selectoption description="Vehicle.valeurAssureeGlobalCar" value="820"/>
								<selectoption description="Vehicle.valeurCatalogueAvecOptions" value="44"/>
								<selectoption description="Vehicle.valeurCatalogueSansPlus" value="198"/>
								<selectoption description="Vehicle.valeurDesAccessoires" value="41"/>
								<selectoption description="Vehicle.valeurExpertise" value="201"/>
								<selectoption description="Vehicle.valeurMaximumBagages" value="202"/>
								<selectoption description="Vehicle.valeurPremierRisque" value="36"/>
								<selectoption description="Vehicle.valeurVitrage" value="203"/>
								<selectoption description="Vehicle.versionTexteLibre" value="129"/>
								<selectoption description="VehiclePremiumCalculation.age" value="924"/>
								<selectoption description="VehiclePremiumCalculation.caracteristiques" value="1177"/>
								<selectoption description="VehiclePremiumCalculation.rapportPoidsPuissance" value="925"/>
								<selectoption description="VehiclePremiumCalculation.typePuissanceCylindree" value="1178"/>
								<selectoption description="VehicleReference.libelleMarque" value="239"/>
								<selectoption description="VehicleReference.libelleModele" value="240"/>
								<selectoption description="VehicleReference.libelleVersion" value="241"/>
								<selectoption description="VehicleReference.rapportPuissancePoids" value="1210"/>
								<selectoption description="Z_FK." value="303"/>
							</combobox>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="codes">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="codes">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<template match="code">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position()  &gt; 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<text fixtext=", ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<text fixtext="code(">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<template match="@source">
										<editorproperties elementstodisplay="1" elementstofetch="all"/>
										<properties/>
										<styles/>
										<children>
											<text fixtext="source=">
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</text>
											<combobox xpath="doc(&quot;codes.xml&quot;)/codesTable/codeGroup/codeSource">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format datatype="string"/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
										<addvalidations/>
										<sort/>
									</template>
									<text fixtext=" ">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="@source=&quot;Code.branche&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.branche&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.mouvement&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.mouvement&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.compagnieRegroupement&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.compagnieRegroupement&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.particularité&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.particularité&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Vehicle.genre&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Vehicle.genre&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Vehicle.usage&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Vehicle.usage&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Type.plaque1&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Type.plaque1&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties size="1"/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.puissance&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.puissance&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties size="1"/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.présenceMobilophone&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.présenceMobilophone&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties size="1"/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Vehicle.type&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Vehicle.type&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.fractionnement&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.fractionnement&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.motifFinDeGarantie&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.motifFinDeGarantie&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.sexe&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.sexe&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.motifPoliceConnexeOuRemplacee&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.motifPoliceConnexeOuRemplacee&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.compagnieOrigine&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.compagnieOrigine&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
											<conditionbranch xpath="@source=&quot;Code.compagnieDeGestion&quot;">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.compagnieDeGestion&quot;]/codeDefinition/codeName">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
														<addvalidations/>
													</combobox>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<text fixtext=")">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="code">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="code">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="code(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="@source">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<text fixtext="source=">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<combobox xpath="doc(&quot;codes.xml&quot;)/codesTable/codeGroup/codeSource">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<content>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
												<addvalidations/>
												<format datatype="string"/>
											</content>
										</children>
										<addvalidations/>
									</combobox>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<condition>
								<editorproperties/>
								<properties/>
								<styles/>
								<children>
									<conditionbranch xpath="@source=&quot;Code.branche&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.branche&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.mouvement&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.mouvement&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.compagnieRegroupement&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.compagnieRegroupement&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.particularité&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.particularité&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Vehicle.genre&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Vehicle.genre&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Vehicle.usage&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Vehicle.usage&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Type.plaque1&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Type.plaque1&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties size="1"/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.puissance&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.puissance&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties size="1"/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.présenceMobilophone&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.présenceMobilophone&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties size="1"/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Vehicle.type&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Vehicle.type&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.fractionnement&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.fractionnement&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.motifFinDeGarantie&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.motifFinDeGarantie&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.sexe&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.sexe&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.motifPoliceConnexeOuRemplacee&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.motifPoliceConnexeOuRemplacee&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.compagnieOrigine&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.compagnieOrigine&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@source=&quot;Code.compagnieDeGestion&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Codes.xml&quot;)/codesTable/codeGroup[codeSource=&quot;Code.compagnieDeGestion&quot;]/codeDefinition/codeName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="constants">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="constants">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<template match="constant">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position()  &gt; 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<text fixtext=", ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<text fixtext="constant(">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<combobox xpath="doc(&quot;Constants.xml&quot;)/constantsTable/constantDefinition/constantName">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<content>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
												<addvalidations/>
												<format datatype="anyType"/>
											</content>
										</children>
										<addvalidations/>
									</combobox>
									<text fixtext=")">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="constant">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="constant">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="constant(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<combobox xpath="doc(&quot;Constants.xml&quot;)/constantsTable/constantDefinition/constantName">
								<editorproperties/>
								<properties/>
								<styles/>
								<children>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format datatype="anyType"/>
									</content>
								</children>
								<addvalidations/>
							</combobox>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="context">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="context">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<condition>
								<editorproperties/>
								<properties/>
								<styles/>
								<children>
									<conditionbranch xpath="position() &gt; 1">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<table>
								<editorproperties/>
								<properties border="1"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Agreement Type">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="AgreementType">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties size="1"/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Application">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="Application">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Branche">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="Branche">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Compagnie Juridique">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="CompagnieJuridique">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Compagnie Marque">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="CompagnieMarque">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Product">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="Product">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="SalesChannel">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="SalesChannel">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Segment Marche">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="SegmentMarche">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="Transaction">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="Transaction">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left"/>
														<styles font-size="smaller" font-weight="bold"/>
														<children>
															<text fixtext="UserProfile">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="UserProfile">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="divide">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="divide">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" / ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="equal">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="equal">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" = ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="fmod">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="fmod">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="FMOD(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=", ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="foreach">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="foreach">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="0" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<text fixtext="for each ">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
															<template match="@var">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format datatype="anySimpleType"/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
															<text fixtext=" until ">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
															<template match="@until">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format datatype="string"/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles padding-left="10"/>
														<children>
															<template match="condition">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="function">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="function">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<template match="@name">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<combobox xpath="doc(&quot;Functions.xml&quot;)/functionsTable/functionDefinition/functionName">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<content>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
												<addvalidations/>
												<format datatype="anySimpleType"/>
											</content>
										</children>
										<addvalidations/>
									</combobox>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext="(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() &gt; 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<text fixtext=", ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="greater">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="greater">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" &gt; ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="if">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="if">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="center" width="40"/>
														<styles/>
														<children>
															<text fixtext="IF">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="condition">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="center" width="40"/>
														<styles/>
														<children>
															<text fixtext="Y">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="then">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="ifNot">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="ifNot">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="center" width="55"/>
														<styles/>
														<children>
															<text fixtext="IFNOT">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="condition">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="center" width="55"/>
														<styles/>
														<children>
															<text fixtext="Y">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="then">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="in">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="in">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position()  = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" IN ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position()  = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="less">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="less">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" &lt; ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="list">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="list">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="list(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="@name">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<combobox xpath="doc(&quot;lists.xml&quot;)/listsTable/listDefinition/listName">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<content>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
												<addvalidations/>
												<format datatype="anySimpleType"/>
											</content>
										</children>
										<addvalidations/>
									</combobox>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=": ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<content>
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
								<addvalidations/>
								<format/>
							</content>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="literals">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="literals">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<template match="literal">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position()  &gt; 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<text fixtext=", ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<text fixtext="literal (">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format datatype="anyType"/>
									</content>
									<text fixtext=")">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="literal">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="literal">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="literal(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<content>
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
								<addvalidations/>
								<format datatype="anyType"/>
							</content>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="longDescription">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="longDescription">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties valign="top" width="120"/>
														<styles/>
														<children>
															<table>
																<editorproperties/>
																<properties border="0" width="100%"/>
																<styles/>
																<children>
																	<tablebody>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties valign="top" width="50"/>
																						<styles/>
																						<children>
																							<text fixtext="Long">
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children/>
																							</text>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties valign="top" width="50"/>
																						<styles/>
																						<children>
																							<template match="@language">
																								<editorproperties elementstodisplay="1" elementstofetch="all"/>
																								<properties/>
																								<styles/>
																								<children>
																									<combobox enumeration="1">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																										<addvalidations/>
																									</combobox>
																								</children>
																								<addvalidations/>
																								<sort/>
																							</template>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties valign="top" width="50"/>
																						<styles/>
																						<children>
																							<template match="@usage">
																								<editorproperties elementstodisplay="1" elementstofetch="all"/>
																								<properties/>
																								<styles/>
																								<children>
																									<combobox enumeration="1">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																										<addvalidations/>
																									</combobox>
																								</children>
																								<addvalidations/>
																								<sort/>
																							</template>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties valign="top" width="50"/>
																						<styles/>
																						<children>
																							<template match="@userProfile">
																								<editorproperties elementstodisplay="1" elementstofetch="all"/>
																								<properties/>
																								<styles/>
																								<children>
																									<combobox enumeration="1">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																										<addvalidations/>
																									</combobox>
																								</children>
																								<addvalidations/>
																								<sort/>
																							</template>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties valign="top"/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="max">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="max">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="MAX(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() &gt; 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<text fixtext=", ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="min">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="min">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="MIN(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() &gt; 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<text fixtext=", ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="minus">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="minus">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" - ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="multiply">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="multiply">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" * ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="not">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="not">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<template match="condition">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<text fixtext="NOT ">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="notEqual">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="notEqual">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" &lt;&gt; ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="notLess">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="notLess">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" &gt;= ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="notGreater">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="notGreater">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 1">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" &lt;= ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<condition>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<conditionbranch xpath="position() = 2">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<addvalidations/>
								<sort/>
							</template>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="or">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="or">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles border-collapse="collapse"/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="center" valign="middle" width="45"/>
														<styles/>
														<children>
															<text fixtext="OR">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<table>
																<editorproperties/>
																<properties border="1" width="100%"/>
																<styles border-collapse="collapse"/>
																<children>
																	<tablebody>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<template match="condition">
																				<editorproperties elementstodisplay="1" elementstofetch="all"/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablerow>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablecell>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																										<addvalidations/>
																										<format/>
																									</content>
																								</children>
																							</tablecell>
																						</children>
																					</tablerow>
																				</children>
																				<addvalidations/>
																				<sort/>
																			</template>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="ruleLogic">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="ruleLogic">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<content>
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
								<addvalidations/>
								<format/>
							</content>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="shortDescription">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="shortDescription">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties valign="top" width="120"/>
														<styles/>
														<children>
															<table>
																<editorproperties/>
																<properties border="0" width="100%"/>
																<styles/>
																<children>
																	<tablebody>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties valign="top"/>
																						<styles/>
																						<children>
																							<text fixtext="Short">
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children/>
																							</text>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties valign="top"/>
																						<styles/>
																						<children>
																							<template match="@language">
																								<editorproperties elementstodisplay="1" elementstofetch="all"/>
																								<properties/>
																								<styles/>
																								<children>
																									<combobox enumeration="1">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																										<addvalidations/>
																									</combobox>
																								</children>
																								<addvalidations/>
																								<sort/>
																							</template>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties valign="top"/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="textualDescription">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="textualDescription">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties height="22"/>
														<styles/>
														<children>
															<template match="longDescription">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="businessRule">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="businessRule">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Rule ID">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<table>
																<editorproperties/>
																<properties border="1" width="100%"/>
																<styles/>
																<children>
																	<tablebody>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties align="left" valign="top" width="337"/>
																						<styles font-weight="bold"/>
																						<children>
																							<template match="@RuleID">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																										<addvalidations/>
																										<format datatype="string"/>
																									</content>
																								</children>
																								<addvalidations/>
																								<sort/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="right" valign="top" width="107"/>
																						<styles font-weight="bold"/>
																						<children>
																							<text fixtext="Creation Date">
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children/>
																							</text>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="right" valign="top"/>
																						<styles font-weight="bold"/>
																						<children>
																							<template match="@CreationDate">
																								<editorproperties elementstodisplay="1" elementstofetch="all"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																										<addvalidations/>
																										<format datatype="anySimpleType"/>
																									</content>
																								</children>
																								<addvalidations/>
																								<sort/>
																							</template>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Type">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<text fixtext="Business Rule">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" height="23" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Status">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties height="23"/>
														<styles/>
														<children>
															<template match="@Status">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Owner BSP">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="@ownerBSP">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Owner IT">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="@ownerIT">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Category">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="@Category">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Descriptions">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="textualDescription">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Contexts">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="contexts">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Rule Sets">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="ruleSets">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1"/>
																		<styles/>
																		<children>
																			<tableheader>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablerow>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablecell headercell="1">
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<text fixtext="Rule Set">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																									</text>
																								</children>
																							</tablecell>
																							<tablecell headercell="1">
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<text fixtext="Instances">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																									</text>
																								</children>
																							</tablecell>
																						</children>
																					</tablerow>
																				</children>
																			</tableheader>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="ruleSet">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<template match="ruleSetName">
																												<editorproperties elementstodisplay="1" elementstofetch="all"/>
																												<properties/>
																												<styles/>
																												<children>
																													<combobox enumeration="1">
																														<editorproperties/>
																														<properties/>
																														<styles/>
																														<children>
																															<content>
																																<editorproperties/>
																																<properties/>
																																<styles/>
																																<children/>
																																<addvalidations/>
																																<format datatype="string"/>
																															</content>
																														</children>
																														<addvalidations/>
																													</combobox>
																												</children>
																												<addvalidations/>
																												<sort/>
																											</template>
																										</children>
																									</tablecell>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<template match="instances">
																												<editorproperties elementstodisplay="1" elementstofetch="all"/>
																												<properties/>
																												<styles/>
																												<children>
																													<table>
																														<editorproperties/>
																														<properties border="1"/>
																														<styles/>
																														<children>
																															<tablebody>
																																<editorproperties/>
																																<properties/>
																																<styles/>
																																<children>
																																	<template match="instance">
																																		<editorproperties elementstodisplay="1" elementstofetch="all"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<tablerow>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children>
																																					<tablecell>
																																						<editorproperties/>
																																						<properties/>
																																						<styles/>
																																						<children>
																																							<condition>
																																								<editorproperties/>
																																								<properties/>
																																								<styles/>
																																								<children>
																																									<conditionbranch xpath="../../ruleSetName/text()=&quot;Party&quot;">
																																										<editorproperties/>
																																										<properties/>
																																										<styles/>
																																										<children>
																																											<combobox>
																																												<editorproperties/>
																																												<properties/>
																																												<styles/>
																																												<children>
																																													<content>
																																														<editorproperties/>
																																														<properties/>
																																														<styles/>
																																														<children/>
																																														<addvalidations/>
																																														<format datatype="anyType"/>
																																													</content>
																																												</children>
																																												<addvalidations/>
																																												<selectoption description="PolicyHolder" value="1"/>
																																												<selectoption description="MainDriver" value="2"/>
																																												<selectoption description="SecondaryDriver1" value="3"/>
																																												<selectoption description="SecondaryDriver2" value="4"/>
																																											</combobox>
																																										</children>
																																									</conditionbranch>
																																									<conditionbranch xpath="../../ruleSetName/text()=&quot;Risk&quot;">
																																										<editorproperties/>
																																										<properties/>
																																										<styles/>
																																										<children>
																																											<combobox>
																																												<editorproperties/>
																																												<properties/>
																																												<styles/>
																																												<children>
																																													<content>
																																														<editorproperties/>
																																														<properties/>
																																														<styles/>
																																														<children/>
																																														<addvalidations/>
																																														<format datatype="anyType"/>
																																													</content>
																																												</children>
																																												<addvalidations/>
																																												<selectoption description="Risk1" value="1"/>
																																												<selectoption description="Risk2" value="2"/>
																																												<selectoption description="Risk3" value="3"/>
																																											</combobox>
																																										</children>
																																									</conditionbranch>
																																									<conditionbranch xpath="../../ruleSetName/text()=&quot;Agreement&quot;">
																																										<editorproperties/>
																																										<properties/>
																																										<styles/>
																																										<children>
																																											<combobox>
																																												<editorproperties/>
																																												<properties/>
																																												<styles/>
																																												<children>
																																													<content>
																																														<editorproperties/>
																																														<properties/>
																																														<styles/>
																																														<children/>
																																														<addvalidations/>
																																														<format datatype="anyType"/>
																																													</content>
																																												</children>
																																												<addvalidations/>
																																												<selectoption description="Retrocessions" value="1"/>
																																												<selectoption description="Majorations/Reductions" value="2"/>
																																												<selectoption description="Segmentations" value="3"/>
																																											</combobox>
																																										</children>
																																									</conditionbranch>
																																									<conditionbranch xpath="../../ruleSetName/text()=&quot;Coverage&quot;">
																																										<editorproperties/>
																																										<properties/>
																																										<styles/>
																																										<children>
																																											<combobox>
																																												<editorproperties/>
																																												<properties/>
																																												<styles/>
																																												<children>
																																													<content>
																																														<editorproperties/>
																																														<properties/>
																																														<styles/>
																																														<children/>
																																														<addvalidations/>
																																														<format datatype="anyType"/>
																																													</content>
																																												</children>
																																												<addvalidations/>
																																												<selectoption description="001  Responsabilité civile" value="001"/>
																																												<selectoption description="010  Protection juridique circulation" value="010"/>
																																												<selectoption description="011  Nature / Animaux" value="011"/>
																																												<selectoption description="012  Incendie" value="012"/>
																																												<selectoption description="013  Bris vitres" value="013"/>
																																												<selectoption description="014  Vol" value="014"/>
																																												<selectoption description="015  Accident / Vandalisme" value="015"/>
																																												<selectoption description="022  OMNI Assistance personnes" value="022"/>
																																												<selectoption description="023  OMNI Assistance véhicules" value="023"/>
																																												<selectoption description="026  Protection des personnes indemnité" value="026"/>
																																												<selectoption description="027  Protection des personnes forfait" value="027"/>
																																											</combobox>
																																										</children>
																																									</conditionbranch>
																																									<conditionbranch xpath="../../ruleSetName/text()=&quot;MainCoverage&quot;">
																																										<editorproperties/>
																																										<properties/>
																																										<styles/>
																																										<children>
																																											<combobox>
																																												<editorproperties/>
																																												<properties/>
																																												<styles/>
																																												<children>
																																													<content>
																																														<editorproperties/>
																																														<properties/>
																																														<styles/>
																																														<children/>
																																														<addvalidations/>
																																														<format datatype="anyType"/>
																																													</content>
																																												</children>
																																												<addvalidations/>
																																												<selectoption description="Responsabilité civile " value="RC"/>
																																												<selectoption description="Protection du véhicule" value="PV"/>
																																												<selectoption description="Assistance aux personnes" value="AP"/>
																																												<selectoption description="Assistance aux véhicules" value="AV"/>
																																												<selectoption description="Protection juridique" value="PJ"/>
																																											</combobox>
																																										</children>
																																									</conditionbranch>
																																								</children>
																																							</condition>
																																						</children>
																																					</tablecell>
																																				</children>
																																			</tablerow>
																																		</children>
																																		<addvalidations/>
																																		<sort/>
																																	</template>
																																</children>
																															</tablebody>
																														</children>
																													</table>
																												</children>
																												<addvalidations/>
																												<sort/>
																											</template>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Targets">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="targets">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1" width="100%"/>
																		<styles/>
																		<children>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="target">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content match="bcm">
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format/>
																											</content>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Rule Logic">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<content match="ruleLogic">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format/>
															</content>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" height="24" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Included">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="includes">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1" width="100%"/>
																		<styles/>
																		<children>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="include">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="anyType"/>
																											</content>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles font-weight="bold"/>
														<children>
															<text fixtext="Comments">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="comments">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1" width="100%"/>
																		<styles/>
																		<children>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="comment">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="businessFunction">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="businessFunction">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Function ID">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="@FunctionID">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format datatype="integer"/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Status">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="@Status">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Name">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="@name">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format datatype="string"/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Body">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="body">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Parameters">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="params">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1" width="100%"/>
																		<styles/>
																		<children>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="param">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="anyType"/>
																											</content>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Result Type">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="resultType">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Descriptions">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="textualDescription">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Includes">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="includes">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1" width="100%"/>
																		<styles/>
																		<children>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="include">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="anyType"/>
																											</content>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell headercell="1">
														<editorproperties/>
														<properties align="left" valign="top" width="120"/>
														<styles/>
														<children>
															<text fixtext="Comments">
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
															</text>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="comments">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<table>
																		<editorproperties/>
																		<properties border="1" width="100%"/>
																		<styles/>
																		<children>
																			<tablebody>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<template match="comment">
																						<editorproperties elementstodisplay="1" elementstofetch="all"/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																						<addvalidations/>
																						<sort/>
																					</template>
																				</children>
																			</tablebody>
																		</children>
																	</table>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="placeHolder">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="placeHolder">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="{">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="@type">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<combobox enumeration="1">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<content>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
												<addvalidations/>
												<format datatype="string"/>
											</content>
										</children>
										<addvalidations/>
									</combobox>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<condition>
								<editorproperties/>
								<properties/>
								<styles/>
								<children>
									<conditionbranch xpath="@type=&quot;constant&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Constants.xml&quot;)/constantsTable/constantDefinition/constantName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@type=&quot;list&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Lists.xml&quot;)/listsTable/listDefinition/listName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@type=&quot;function&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox xpath="doc(&quot;Functions.xml&quot;)/functionsTable/functionDefinition/functionName">
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
											</combobox>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@type=&quot;bcm&quot;">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<combobox>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<content>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
														<addvalidations/>
														<format/>
													</content>
												</children>
												<addvalidations/>
												<selectoption description="Accident.dateDeNaissanceAssure" value="772"/>
												<selectoption description="Accident.entite" value="1120"/>
												<selectoption description="Accident.gensMaisonCodeNACE" value="776"/>
												<selectoption description="Accident.gensMaisonNumeroONSS" value="777"/>
												<selectoption description="Accident.libelleParticulariteGestion" value="768"/>
												<selectoption description="Accident.natureDuRisquePrincipal" value="771"/>
												<selectoption description="Accident.nombreDePersonnesAssurees" value="770"/>
												<selectoption description="Accident.particularitesGestion" value="1083"/>
												<selectoption description="Accident.particularitesGestion[1]" value="1081"/>
												<selectoption description="Accident.particularitesGestion[2]" value="767"/>
												<selectoption description="Accident.particularitesProduitUUAP" value="775"/>
												<selectoption description="Accident.professionPrincipale" value="769"/>
												<selectoption description="Accident.sexeDeLAssure" value="774"/>
												<selectoption description="Accident.typeDAssure" value="773"/>
												<selectoption description="Agenda.datePlanifiee" value="684"/>
												<selectoption description="Agenda.destinataire" value="687"/>
												<selectoption description="Agenda.langue" value="688"/>
												<selectoption description="Agenda.libelleLibre" value="685"/>
												<selectoption description="Agenda.numeroDeLettre" value="683"/>
												<selectoption description="Agenda.numeroGestionnaire" value="689"/>
												<selectoption description="Agenda.rappel" value="686"/>
												<selectoption description="Agenda.type" value="690"/>
												<selectoption description="Agreement.BMaPosteriori" value="165"/>
												<selectoption description="Agreement.antecedentsTempo1" value="212"/>
												<selectoption description="Agreement.antecedentsTempo2" value="287"/>
												<selectoption description="Agreement.applicationOrigineDuContrat" value="1261"/>
												<selectoption description="Agreement.attestationSinistreDelivree" value="166"/>
												<selectoption description="Agreement.branche" value="156"/>
												<selectoption description="Agreement.canalDeGestion" value="39"/>
												<selectoption description="Agreement.codeDeterminationCiePourAccesTablesAnnexes" value="972"/>
												<selectoption description="Agreement.codeEMIRegionDerogatoireDuCourtier" value="285"/>
												<selectoption description="Agreement.codeSINRegionDerogatoireDuCourtier" value="284"/>
												<selectoption description="Agreement.compagnieDEmission" value="7"/>
												<selectoption description="Agreement.compagnieDOrigine" value="167"/>
												<selectoption description="Agreement.compagnieDeGestion" value="40"/>
												<selectoption description="Agreement.contratDOrigineUAB" value="164"/>
												<selectoption description="Agreement.conversion" value="785"/>
												<selectoption description="Agreement.courrierGenius" value="289"/>
												<selectoption description="Agreement.dateConditionsGenerales" value="1208"/>
												<selectoption description="Agreement.dateCreationSituationContrat" value="179"/>
												<selectoption description="Agreement.dateDArchivage" value="217"/>
												<selectoption description="Agreement.dateDEcheancePrincipale" value="1207"/>
												<selectoption description="Agreement.dateDEffetPremiereSituation" value="210"/>
												<selectoption description="Agreement.dateDEffetSituationContrat" value="983"/>
												<selectoption description="Agreement.dateDeCreationPremierePolice" value="899"/>
												<selectoption description="Agreement.datePAVDDCRE" value="5"/>
												<selectoption description="Agreement.datePremierEffetRC" value="226"/>
												<selectoption description="Agreement.dateProchaineQuittanceTerme" value="144"/>
												<selectoption description="Agreement.dateReceptionDuCourrier" value="172"/>
												<selectoption description="Agreement.demandeComplete" value="663"/>
												<selectoption description="Agreement.dernierNumeroDOffre" value="980"/>
												<selectoption description="Agreement.dernierNumeroDePolice" value="976"/>
												<selectoption description="Agreement.derniereTransactionEffectuee" value="1000"/>
												<selectoption description="Agreement.deviseDuContrat" value="8"/>
												<selectoption description="Agreement.entite" value="1096"/>
												<selectoption description="Agreement.fractionnement" value="1"/>
												<selectoption description="Agreement.gestionnaire" value="720"/>
												<selectoption description="Agreement.heureCreationSituationDeContrat" value="1032"/>
												<selectoption description="Agreement.indiceDeRenouvellement" value="1036"/>
												<selectoption description="Agreement.joker" value="237"/>
												<selectoption description="Agreement.jokerBM" value="238"/>
												<selectoption description="Agreement.labellisation" value="9"/>
												<selectoption description="Agreement.langue" value="213"/>
												<selectoption description="Agreement.libelleParticulariteGestion" value="177"/>
												<selectoption description="Agreement.mentionIdProducteurDerogatoir" value="247"/>
												<selectoption description="Agreement.methodeDeGestion" value="168"/>
												<selectoption description="Agreement.modeDEncaissement" value="2"/>
												<selectoption description="Agreement.motifDemandeIncomplete" value="664"/>
												<selectoption description="Agreement.natureDeLEvolutionDuContrat" value="1262"/>
												<selectoption description="Agreement.nbreDePersonnesCieClient" value="281"/>
												<selectoption description="Agreement.nombreDeDeclenchementsPCX" value="180"/>
												<selectoption description="Agreement.numero" value="6"/>
												<selectoption description="Agreement.numeroConditionsGenerales" value="134"/>
												<selectoption description="Agreement.numeroDeCx" value="140"/>
												<selectoption description="Agreement.numeroDeDomiciliationBancaire" value="209"/>
												<selectoption description="Agreement.numeroDePolice" value="3"/>
												<selectoption description="Agreement.numeroDePoliceDeBase" value="174"/>
												<selectoption description="Agreement.numeroDeSituation" value="11"/>
												<selectoption description="Agreement.offreLieeAContrat" value="170"/>
												<selectoption description="Agreement.organisation" value="907"/>
												<selectoption description="Agreement.particulariteDeGestion1" value="219"/>
												<selectoption description="Agreement.particulariteDeGestion2" value="220"/>
												<selectoption description="Agreement.particulierCorporate" value="214"/>
												<selectoption description="Agreement.pcxCx" value="139"/>
												<selectoption description="Agreement.policeDeTypeMarsh" value="960"/>
												<selectoption description="Agreement.policeProvientDUneAutreCompagnie" value="279"/>
												<selectoption description="Agreement.referencePreneur" value="661"/>
												<selectoption description="Agreement.referenceProducteur" value="662"/>
												<selectoption description="Agreement.saphir" value="790"/>
												<selectoption description="Agreement.sousAgentLaPoste" value="900"/>
												<selectoption description="Agreement.statutDeLOffre" value="1300"/>
												<selectoption description="Agreement.typeDeContrat" value="1282"/>
												<selectoption description="Agreement.typeDePolice" value="194"/>
												<selectoption description="Agreement.typeDePoliceDeBase" value="173"/>
												<selectoption description="Agreement.typeDeSousAgentLaPoste" value="286"/>
												<selectoption description="AgreementConnexity.entite" value="1115"/>
												<selectoption description="AgreementConnexity.motif" value="711"/>
												<selectoption description="AgreementConnexity.policeConnexe" value="787"/>
												<selectoption description="AgreementPremiumCalculation.coutsDePolice" value="831"/>
												<selectoption description="AgreementPremiumCalculation.dateDeDebut" value="911"/>
												<selectoption description="AgreementPremiumCalculation.dateDeFin" value="912"/>
												<selectoption description="AgreementPremiumCalculation.primeAPayer" value="830"/>
												<selectoption description="AgreementPremiumCalculation.primeCommerciale" value="826"/>
												<selectoption description="AgreementPremiumCalculation.primeTotale" value="910"/>
												<selectoption description="AgreementPremiumCalculation.scalingFactor" value="913"/>
												<selectoption description="AgreementPremiumCalculation.utilisePrimeDeBaseStockee" value="914"/>
												<selectoption description="AgreementProcessingInfo.macroEcranSousTypeDeTransaction" value="1031"/>
												<selectoption description="AntecedentAccident.accidentEnHebriete" value="1023"/>
												<selectoption description="AntecedentAccident.assureInfirme" value="1022"/>
												<selectoption description="AntecedentAccident.entite" value="1125"/>
												<selectoption description="AntecedentAccident.preneurDejaAssure" value="1019"/>
												<selectoption description="AntecedentAccident.resiliationCompagnie" value="1020"/>
												<selectoption description="AntecedentAccident.responsabiliteDejaEngagee" value="1021"/>
												<selectoption description="AntecedentFireNew.aDesCavesCatNat" value="1260"/>
												<selectoption description="AntecedentFireNew.annexesCatNat" value="1016"/>
												<selectoption description="AntecedentFireNew.appartementALEtageCatNat" value="1015"/>
												<selectoption description="AntecedentFireNew.dommageCavesUniquementCatNat" value="1018"/>
												<selectoption description="AntecedentFireNew.entite" value="1124"/>
												<selectoption description="AntecedentFireNew.innondationsDepuis5AnsCatNat" value="1017"/>
												<selectoption description="AntecedentFireNew.preneurDejaAssure" value="1009"/>
												<selectoption description="AntecedentFireNew.preneurDejaAssureRC" value="1012"/>
												<selectoption description="AntecedentFireNew.resiliationCompagnie" value="1010"/>
												<selectoption description="AntecedentFireNew.resiliationCompagnieRC" value="1013"/>
												<selectoption description="AntecedentFireNew.responsabiliteDejaEngageeRC" value="1014"/>
												<selectoption description="AntecedentFireNew.sinistreDepuis5Ans" value="1011"/>
												<selectoption description="AntecedentFireNew.sinistreDepuis5AnsRC" value="1206"/>
												<selectoption description="AntecedentFireOld.entite" value="1123"/>
												<selectoption description="AntecedentFireOld.preneurDejaAssure" value="1001"/>
												<selectoption description="AntecedentFireOld.preneurDejaAssureRC" value="1006"/>
												<selectoption description="AntecedentFireOld.resiliationCompagnie" value="1002"/>
												<selectoption description="AntecedentFireOld.resiliationCompagnieRC" value="1007"/>
												<selectoption description="AntecedentFireOld.responsabiliteDejaEngageeRC" value="1008"/>
												<selectoption description="AntecedentFireOld.sinistreDepuis5Ans" value="1005"/>
												<selectoption description="AntecedentFireOld.sinistreDepuis5AnsRC" value="1205"/>
												<selectoption description="AntecedentVehicle.conducteurContratPrecedentAnnule" value="702"/>
												<selectoption description="AntecedentVehicle.conducteurHandicapMaladie" value="701"/>
												<selectoption description="AntecedentVehicle.conducteurSinistreAvecDelit" value="703"/>
												<selectoption description="AntecedentVehicle.conducteurSinistreEnTort" value="704"/>
												<selectoption description="AntecedentVehicle.entite" value="1126"/>
												<selectoption description="AntecedentVehicle.preneurAntecedents" value="705"/>
												<selectoption description="AntecedentVehicle.preneurContratPrecedentAnnule" value="706"/>
												<selectoption description="AntecedentVehicle.preneurSinistreEnTort" value="707"/>
												<selectoption description="Antecedents.entite" value="1122"/>
												<selectoption description="Broker.codeRegion3" value="1039"/>
												<selectoption description="Broker.compagnieComptable" value="63"/>
												<selectoption description="Broker.compteProducteurCibleDuTransfert" value="819"/>
												<selectoption description="Broker.dateDuTransfertGlobal" value="818"/>
												<selectoption description="Broker.delegationDePouvoir" value="905"/>
												<selectoption description="Broker.entite" value="1097"/>
												<selectoption description="Broker.information" value="1060"/>
												<selectoption description="Broker.information[10]" value="721"/>
												<selectoption description="Broker.information[1]" value="1051"/>
												<selectoption description="Broker.information[2]" value="1052"/>
												<selectoption description="Broker.information[3]" value="1053"/>
												<selectoption description="Broker.information[4]" value="1054"/>
												<selectoption description="Broker.information[5]" value="1055"/>
												<selectoption description="Broker.information[6]" value="1056"/>
												<selectoption description="Broker.information[7]" value="1057"/>
												<selectoption description="Broker.information[8]" value="1058"/>
												<selectoption description="Broker.information[9]" value="1059"/>
												<selectoption description="Broker.marque" value="62"/>
												<selectoption description="Broker.modeDEncaissementBranche" value="1093"/>
												<selectoption description="Broker.modeDEncaissementGeneral" value="872"/>
												<selectoption description="Broker.natureDuCompte" value="897"/>
												<selectoption description="Broker.niveauDAutorisation" value="1220"/>
												<selectoption description="Broker.numeroDeCompteProducteur" value="59"/>
												<selectoption description="Broker.particularite" value="898"/>
												<selectoption description="Broker.particularite2" value="962"/>
												<selectoption description="Broker.particulariteBranche" value="906"/>
												<selectoption description="Broker.reductionPrimeMaximumSurGarantieParSituation" value="1219"/>
												<selectoption description="Broker.region" value="61"/>
												<selectoption description="Broker.scoring" value="1038"/>
												<selectoption description="BrokerHabilitation.bonusMalus" value="1242"/>
												<selectoption description="BrokerHabilitation.degressiviteAgreePV" value="1245"/>
												<selectoption description="BrokerHabilitation.effetDiffere" value="1247"/>
												<selectoption description="BrokerHabilitation.franchiseVolConducteur" value="1246"/>
												<selectoption description="BrokerHabilitation.retroactiviteFire" value="1249"/>
												<selectoption description="BrokerHabilitation.retroactiviteLiability" value="1248"/>
												<selectoption description="BrokerHabilitation.retroactivitePV" value="1241"/>
												<selectoption description="BrokerHabilitation.retroactiviteRC" value="1240"/>
												<selectoption description="BrokerHabilitation.valeurCatalogueAssureNeuf" value="1243"/>
												<selectoption description="BrokerHabilitation.valeurCatalogueAssureOccasion" value="1244"/>
												<selectoption description="BrokerHabilitation.valeurScoring" value="1239"/>
												<selectoption description="ClaimAntecedent.date" value="708"/>
												<selectoption description="ClaimAntecedent.entite" value="1114"/>
												<selectoption description="ClaimAntecedent.montant" value="710"/>
												<selectoption description="ClaimAntecedent.numeroGarantie" value="709"/>
												<selectoption description="Claims.date" value="677"/>
												<selectoption description="Claims.dateDebutRecuperationFranchise" value="681"/>
												<selectoption description="Claims.dateFinRecuperationFranchise" value="682"/>
												<selectoption description="Claims.degats" value="678"/>
												<selectoption description="Claims.entite" value="1112"/>
												<selectoption description="Claims.etatDuDossier" value="680"/>
												<selectoption description="Claims.numero" value="675"/>
												<selectoption description="Claims.particularite" value="679"/>
												<selectoption description="Claims.referenceDuGestionnaire" value="676"/>
												<selectoption description="ClauseDescription.entite" value="1209"/>
												<selectoption description="ClauseDescription.libelleLibre" value="698"/>
												<selectoption description="ClauseDescription.libelleLong" value="700"/>
												<selectoption description="ClauseDescription.numeroDeClause" value="697"/>
												<selectoption description="CommissionCoveragePeriodRelease.montantDeLaCommission" value="817"/>
												<selectoption description="CommissionCoveragePeriodRelease.numeroDeCompteProducteur" value="815"/>
												<selectoption description="CommissionCoveragePeriodRelease.typeDExploitation" value="1026"/>
												<selectoption description="CommissionCoveragePeriodRelease.typeDeCommission" value="816"/>
												<selectoption description="CommissionCoveragePeriodRelease.typeDeCompteProducteur" value="814"/>
												<selectoption description="CompetitorCompany.dateDEffet" value="695"/>
												<selectoption description="CompetitorCompany.dateDeFin" value="696"/>
												<selectoption description="CompetitorCompany.entite" value="1113"/>
												<selectoption description="CompetitorCompany.identiteDeLaCompagnie" value="692"/>
												<selectoption description="CompetitorCompany.montantDeLaPrime" value="694"/>
												<selectoption description="CompetitorCompany.numeroDePoliceConcurrente" value="693"/>
												<selectoption description="CompetitorCompany.typeDeConcurrence" value="691"/>
												<selectoption description="CompetitorCompanySubPeriod.resultat" value="954"/>
												<selectoption description="ComplementaryDescription.dateDEffet" value="278"/>
												<selectoption description="ComplementaryDescription.dateDeFin" value="277"/>
												<selectoption description="ComplementaryDescription.libelle" value="276"/>
												<selectoption description="ComplementaryDescription.numero" value="275"/>
												<selectoption description="Cost.dateDEffet" value="89"/>
												<selectoption description="Cost.dateDeFin" value="90"/>
												<selectoption description="Cost.entite" value="1098"/>
												<selectoption description="Cost.exoneration" value="91"/>
												<selectoption description="Cost.intervention" value="92"/>
												<selectoption description="Cost.qualificatifDeLaValeur" value="94"/>
												<selectoption description="Cost.typeDExploitation" value="188"/>
												<selectoption description="Cost.typeDeChargement" value="93"/>
												<selectoption description="Cost.valeur" value="95"/>
												<selectoption description="CostPeriod.dateDeDebut" value="964"/>
												<selectoption description="CostPeriod.dateDeFin" value="965"/>
												<selectoption description="CostPeriod.exoneration" value="967"/>
												<selectoption description="CostPeriod.intervention" value="966"/>
												<selectoption description="CostPeriod.ordre" value="861"/>
												<selectoption description="CostPeriod.qualificatifDeLaValeur" value="856"/>
												<selectoption description="CostPeriod.resultat" value="860"/>
												<selectoption description="CostPeriod.typeDeChargement" value="855"/>
												<selectoption description="CostPeriod.valeur" value="854"/>
												<selectoption description="CostTotalsForAgreement.chargementTotal" value="836"/>
												<selectoption description="CostTotalsForAgreement.typeDeChargement" value="835"/>
												<selectoption description="Coverage.categorie" value="1024"/>
												<selectoption description="Coverage.categorieSousCategorie" value="143"/>
												<selectoption description="Coverage.compagnieDeGestion" value="162"/>
												<selectoption description="Coverage.dateDEffet" value="14"/>
												<selectoption description="Coverage.dateDExpiration" value="158"/>
												<selectoption description="Coverage.dateDeFin" value="16"/>
												<selectoption description="Coverage.dateDeFinDeGratuite" value="17"/>
												<selectoption description="Coverage.dateDuTarifApplique" value="21"/>
												<selectoption description="Coverage.dureeDeReconductionTacite" value="133"/>
												<selectoption description="Coverage.dureeInitiale" value="157"/>
												<selectoption description="Coverage.emissionPrimeManuelle" value="159"/>
												<selectoption description="Coverage.entite" value="1099"/>
												<selectoption description="Coverage.etatCPCompagnie" value="142"/>
												<selectoption description="Coverage.garantieBloquee" value="1250"/>
												<selectoption description="Coverage.groupeAssistance" value="205"/>
												<selectoption description="Coverage.groupeDeReassurance" value="141"/>
												<selectoption description="Coverage.hausseTarifaire" value="163"/>
												<selectoption description="Coverage.indiceDeBlocage" value="136"/>
												<selectoption description="Coverage.libelleComplementaireAuxCodesOrigineSituation" value="155"/>
												<selectoption description="Coverage.motifFinDeGarantie" value="132"/>
												<selectoption description="Coverage.motifGratuite" value="131"/>
												<selectoption description="Coverage.nombreDePersonnes" value="304"/>
												<selectoption description="Coverage.nombreDeVehicules" value="206"/>
												<selectoption description="Coverage.numeroDeGarantie" value="22"/>
												<selectoption description="Coverage.origineSituation1" value="152"/>
												<selectoption description="Coverage.origineSituation2" value="153"/>
												<selectoption description="Coverage.origineSituation3" value="154"/>
												<selectoption description="Coverage.primeProvisionnelle" value="138"/>
												<selectoption description="Coverage.situationDepasseePourQuittance" value="161"/>
												<selectoption description="Coverage.sousCategorie" value="1025"/>
												<selectoption description="Coverage.tarificationManuelle" value="20"/>
												<selectoption description="Coverage.tauxApplique" value="160"/>
												<selectoption description="Coverage.tauxDeBaseAnnuel" value="137"/>
												<selectoption description="Coverage.typeDIndex" value="18"/>
												<selectoption description="Coverage.valeurDeLIndexALaSouscription" value="19"/>
												<selectoption description="CoverageOption.arrondiFranchise" value="186"/>
												<selectoption description="CoverageOption.dateDEffet" value="27"/>
												<selectoption description="CoverageOption.dateDeFin" value="28"/>
												<selectoption description="CoverageOption.detailALaCarte" value="187"/>
												<selectoption description="CoverageOption.entite" value="1100"/>
												<selectoption description="CoverageOption.fractionnement" value="1175"/>
												<selectoption description="CoverageOption.indexDeDepart" value="68"/>
												<selectoption description="CoverageOption.numeroDOption" value="23"/>
												<selectoption description="CoverageOption.qualificatifDeLaValeur" value="25"/>
												<selectoption description="CoverageOption.resultat" value="185"/>
												<selectoption description="CoverageOption.typeDIndexation" value="67"/>
												<selectoption description="CoverageOption.typeDOption" value="24"/>
												<selectoption description="CoverageOption.valeur" value="26"/>
												<selectoption description="CoveragePeriodRelease.dateDEffet" value="803"/>
												<selectoption description="CoveragePeriodRelease.dateDeFin" value="804"/>
												<selectoption description="CoveragePeriodRelease.numeroDeGarantie" value="802"/>
												<selectoption description="CoveragePeriodRelease.primeNetteTotale" value="805"/>
												<selectoption description="CoveragePeriodRelease.typeDIndexation" value="806"/>
												<selectoption description="CoveragePeriodRelease.typeDePersonnalisation" value="808"/>
												<selectoption description="CoveragePeriodRelease.valeurDeLIndex" value="807"/>
												<selectoption description="CoveragePeriodRelease.valeurDePersonnalisation" value="809"/>
												<selectoption description="CoveragePremiumCalculationPeriod.dateDeDebut" value="845"/>
												<selectoption description="CoveragePremiumCalculationPeriod.dateDeFin" value="846"/>
												<selectoption description="CoveragePremiumCalculationPeriod.dateDeReferenceChargementsCie" value="915"/>
												<selectoption description="CoveragePremiumCalculationPeriod.dateDeReferenceChargementsLegaux" value="916"/>
												<selectoption description="CoveragePremiumCalculationPeriod.dateDeReferenceIndex" value="842"/>
												<selectoption description="CoveragePremiumCalculationPeriod.dateDuTarifApplique" value="922"/>
												<selectoption description="CoveragePremiumCalculationPeriod.flagDeCalcul" value="979"/>
												<selectoption description="CoveragePremiumCalculationPeriod.indexDerogatoire" value="843"/>
												<selectoption description="CoveragePremiumCalculationPeriod.indexPeriodeCalcul" value="844"/>
												<selectoption description="CoveragePremiumCalculationPeriod.montantDeBaseDeLaCommissionIndexee" value="901"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primeCommerciale" value="838"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primeDeBase" value="840"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primeDeBaseAnnuelle" value="837"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primeIntermediaire" value="920"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primeMinimaleBT" value="919"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primePureReelle" value="921"/>
												<selectoption description="CoveragePremiumCalculationPeriod.primeTotale" value="839"/>
												<selectoption description="CoveragePremiumCalculationPeriod.tarifPrimeDeBaseManuel" value="923"/>
												<selectoption description="CoveragePremiumCalculationPeriod.totalDeChargementsCompagnie" value="917"/>
												<selectoption description="CoveragePremiumCalculationPeriod.totalDeChargementsLegaux" value="918"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.dateDeDebut" value="863"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.dateDeFin" value="864"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.montantDeBaseDeLaCommissionIndexee" value="1302"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.primeCommerciale" value="868"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.primeDeBase" value="862"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.primeIntermediaire" value="871"/>
												<selectoption description="CoveragePremiumCalculationSubPeriod.prorata" value="867"/>
												<selectoption description="EvaluationGrid.codePostal" value="1004"/>
												<selectoption description="EvaluationGrid.critere" value="765"/>
												<selectoption description="EvaluationGrid.entite" value="1119"/>
												<selectoption description="EvaluationGrid.nombre" value="766"/>
												<selectoption description="EvaluationGrid.nombreDEmplacementVoiture" value="988"/>
												<selectoption description="EvaluationGrid.nombreDeBureau" value="990"/>
												<selectoption description="EvaluationGrid.nombreDeCave" value="986"/>
												<selectoption description="EvaluationGrid.nombreDeChambre" value="989"/>
												<selectoption description="EvaluationGrid.nombreDeGarage" value="987"/>
												<selectoption description="EvaluationGrid.nombreDeGrenier" value="999"/>
												<selectoption description="EvaluationGrid.nombreDeLiving" value="984"/>
												<selectoption description="EvaluationGrid.nombreDePieceAutre" value="991"/>
												<selectoption description="EvaluationGrid.nombreDeSalleDeBain" value="985"/>
												<selectoption description="EvaluationGrid.nombreDeVeranda" value="1003"/>
												<selectoption description="EvaluationGrid.plafondHaut" value="993"/>
												<selectoption description="EvaluationGrid.plusDUneSalleDeBain" value="992"/>
												<selectoption description="EvaluationGrid.presenceAscensseur" value="995"/>
												<selectoption description="EvaluationGrid.quatreFacade" value="996"/>
												<selectoption description="EvaluationGrid.rangeeCinqMetres" value="998"/>
												<selectoption description="EvaluationGrid.solPierreNature" value="994"/>
												<selectoption description="EvaluationGrid.toitureMateriauxNobles" value="1040"/>
												<selectoption description="Fire.adresseDuRisque" value="738"/>
												<selectoption description="Fire.calculDuCapital" value="755"/>
												<selectoption description="Fire.capitalContenant" value="732"/>
												<selectoption description="Fire.capitalContenu" value="733"/>
												<selectoption description="Fire.capitalDeReferenceVolumeIdeal" value="740"/>
												<selectoption description="Fire.classeDuRisque" value="728"/>
												<selectoption description="Fire.contiguite" value="731"/>
												<selectoption description="Fire.dateDeNaissance" value="754"/>
												<selectoption description="Fire.dateDeReceptionDesTravaux" value="752"/>
												<selectoption description="Fire.entite" value="1116"/>
												<selectoption description="Fire.libelleParticulariteGestion" value="745"/>
												<selectoption description="Fire.loyerAnnuelChargesInclues" value="741"/>
												<selectoption description="Fire.montantLimiteDIndemnite" value="746"/>
												<selectoption description="Fire.nombreDeBatiments" value="756"/>
												<selectoption description="Fire.nombreDeLogements" value="734"/>
												<selectoption description="Fire.nombreDePieces" value="727"/>
												<selectoption description="Fire.nombreDeRisques" value="739"/>
												<selectoption description="Fire.nombreDeTranches" value="750"/>
												<selectoption description="Fire.nombreDeVehicules" value="747"/>
												<selectoption description="Fire.nouvelleConstruction" value="751"/>
												<selectoption description="Fire.occupationDuRisque" value="730"/>
												<selectoption description="Fire.particularitesGestion" value="1084"/>
												<selectoption description="Fire.particularitesGestion[1]" value="1082"/>
												<selectoption description="Fire.particularitesGestion[2]" value="744"/>
												<selectoption description="Fire.preventionVol" value="753"/>
												<selectoption description="Fire.qualiteDuProprietaireDuBatiment" value="729"/>
												<selectoption description="Fire.score" value="748"/>
												<selectoption description="Fire.superficie" value="742"/>
												<selectoption description="Fire.typeDHabitation" value="724"/>
												<selectoption description="Fire.typeDeConstruction" value="735"/>
												<selectoption description="Fire.typeDeCouvertureContenant" value="737"/>
												<selectoption description="Fire.typeDeCouvertureContenu" value="736"/>
												<selectoption description="Fire.typeDeFinition" value="726"/>
												<selectoption description="Fire.typeDeFormule" value="743"/>
												<selectoption description="Fire.typeDeGrille" value="725"/>
												<selectoption description="Fire.typeDeTranche" value="749"/>
												<selectoption description="Fleet.blocageHausseTarifaire" value="973"/>
												<selectoption description="Fleet.clause" value="1050"/>
												<selectoption description="Fleet.clause[1]" value="1041"/>
												<selectoption description="Fleet.clause[2]" value="1042"/>
												<selectoption description="Fleet.clause[3]" value="1043"/>
												<selectoption description="Fleet.clause[4]" value="331"/>
												<selectoption description="Fleet.codePostal" value="718"/>
												<selectoption description="Fleet.compagnie" value="332"/>
												<selectoption description="Fleet.compteFinancier" value="321"/>
												<selectoption description="Fleet.dateDAssainissement" value="326"/>
												<selectoption description="Fleet.dateDeDerniereModification" value="315"/>
												<selectoption description="Fleet.dateDeFin" value="719"/>
												<selectoption description="Fleet.dateIntroductionParticulierCorporate" value="314"/>
												<selectoption description="Fleet.demandeDAffiliationGenius" value="318"/>
												<selectoption description="Fleet.demandeDeMailingGenius" value="316"/>
												<selectoption description="Fleet.intitule" value="308"/>
												<selectoption description="Fleet.libelleComplementaire" value="309"/>
												<selectoption description="Fleet.libelleLibreGarantie" value="1070"/>
												<selectoption description="Fleet.libelleLibreGarantie[10]" value="329"/>
												<selectoption description="Fleet.libelleLibreGarantie[1]" value="1061"/>
												<selectoption description="Fleet.libelleLibreGarantie[2]" value="1062"/>
												<selectoption description="Fleet.libelleLibreGarantie[3]" value="1063"/>
												<selectoption description="Fleet.libelleLibreGarantie[4]" value="1064"/>
												<selectoption description="Fleet.libelleLibreGarantie[5]" value="1065"/>
												<selectoption description="Fleet.libelleLibreGarantie[6]" value="1066"/>
												<selectoption description="Fleet.libelleLibreGarantie[7]" value="1067"/>
												<selectoption description="Fleet.libelleLibreGarantie[8]" value="1068"/>
												<selectoption description="Fleet.libelleLibreGarantie[9]" value="1069"/>
												<selectoption description="Fleet.memoDAssainissement" value="327"/>
												<selectoption description="Fleet.nomPersonneDeContact" value="322"/>
												<selectoption description="Fleet.nombreDePersonnes" value="317"/>
												<selectoption description="Fleet.numeroDeRegroupement" value="606"/>
												<selectoption description="Fleet.numeroFormuleSimple" value="311"/>
												<selectoption description="Fleet.numeroGrandCompte" value="310"/>
												<selectoption description="Fleet.organisation" value="313"/>
												<selectoption description="Fleet.particulierCorporate" value="312"/>
												<selectoption description="Fleet.produit" value="717"/>
												<selectoption description="Fleet.regionDeGestionSinistre" value="320"/>
												<selectoption description="Fleet.statut" value="716"/>
												<selectoption description="Fleet.type" value="328"/>
												<selectoption description="Fleet.type" value="610"/>
												<selectoption description="Fleet.typeDAssainissement" value="325"/>
												<selectoption description="Fleet.typeDeDestinataireGenius" value="319"/>
												<selectoption description="Fleet.typeDeGestion" value="323"/>
												<selectoption description="Fleet.typeDeRegroupement" value="604"/>
												<selectoption description="Fleet.useridGestionnaireDeModification" value="324"/>
												<selectoption description="GlobalRelease.dedoublement" value="887"/>
												<selectoption description="GlobalRelease.marque" value="894"/>
												<selectoption description="GlobalRelease.modele" value="895"/>
												<selectoption description="GlobalRelease.ordreQuittanceGlobale" value="884"/>
												<selectoption description="GlobalRelease.ordreQuittanceGlobaleDedoublee" value="889"/>
												<selectoption description="GlobalRelease.plaque" value="893"/>
												<selectoption description="GlobalRelease.policeMere" value="882"/>
												<selectoption description="GlobalRelease.quittanceAnnulee" value="891"/>
												<selectoption description="GlobalRelease.quittanceGlobale" value="883"/>
												<selectoption description="GlobalRelease.quittanceGlobaleDedoublee" value="888"/>
												<selectoption description="GlobalRelease.reglobalisation" value="890"/>
												<selectoption description="GlobalRelease.sequenceDetailQuittanceGlobale" value="886"/>
												<selectoption description="GlobalRelease.situationContractuelle" value="885"/>
												<selectoption description="GlobalRelease.typeDePlaque" value="892"/>
												<selectoption description="GlobalRelease.version" value="896"/>
												<selectoption description="Index.dateDEffet" value="822"/>
												<selectoption description="Index.dateDeFin" value="823"/>
												<selectoption description="Index.entite" value="1121"/>
												<selectoption description="Index.typeDIndex" value="821"/>
												<selectoption description="Index.valeur" value="824"/>
												<selectoption description="InsurableObject.entite" value="1107"/>
												<selectoption description="InsurableObject.numeroDeReferenceRisquePrincipal" value="904"/>
												<selectoption description="InsurableObject.numeroDeSequenceDuRisque" value="225"/>
												<selectoption description="LegalCostCoveragePeriodRelease.chargementManuel" value="812"/>
												<selectoption description="LegalCostCoveragePeriodRelease.exonerationDuChargement" value="813"/>
												<selectoption description="LegalCostCoveragePeriodRelease.montant" value="811"/>
												<selectoption description="LegalCostCoveragePeriodRelease.type" value="810"/>
												<selectoption description="MainDriver.aDesEnfants" value="712"/>
												<selectoption description="MainDriver.entite" value="1101"/>
												<selectoption description="MainDriver.etatStageDeConduite" value="621"/>
												<selectoption description="MainDriver.parentsAssuresChezAXA" value="58"/>
												<selectoption description="MainDriver.suiviStageDeConduite" value="69"/>
												<selectoption description="MainDriver.tarifJeuneConducteur" value="1301"/>
												<selectoption description="MajorationReduction.dateDEffet" value="296"/>
												<selectoption description="MajorationReduction.dateDeFin" value="295"/>
												<selectoption description="MajorationReduction.derogeAuxDatesGarantie" value="1037"/>
												<selectoption description="MajorationReduction.indexation" value="80"/>
												<selectoption description="MajorationReduction.indiceDeBlocage" value="292"/>
												<selectoption description="MajorationReduction.libelleLibre" value="294"/>
												<selectoption description="MajorationReduction.libelleLong" value="699"/>
												<selectoption description="MajorationReduction.numeroDOrdreDAppel" value="307"/>
												<selectoption description="MajorationReduction.numeroDeMajorationReduction" value="297"/>
												<selectoption description="MajorationReduction.qualificatifDeLaValeur" value="81"/>
												<selectoption description="MajorationReduction.qualificatifMajorationReduction" value="97"/>
												<selectoption description="MajorationReduction.resultatDuCalcul" value="103"/>
												<selectoption description="MajorationReduction.tarificationManuelle" value="293"/>
												<selectoption description="MajorationReduction.valeur" value="84"/>
												<selectoption description="MajorationReductionPeriod.resultat" value="853"/>
												<selectoption description="MajorationReductionSubPeriod.numeroDeSequence" value="971"/>
												<selectoption description="MajorationReductionSubPeriod.resultat" value="955"/>
												<selectoption description="MajorationReductionSubPeriod.typeDeDerogation" value="969"/>
												<selectoption description="MajorationReductionSubPeriod.typeDePrime" value="970"/>
												<selectoption description="Operation.application" value="655"/>
												<selectoption description="Operation.ecran" value="788"/>
												<selectoption description="Operation.statutDuCopy" value="616"/>
												<selectoption description="Operation.texteLibre" value="789"/>
												<selectoption description="Operation.transaction" value="622"/>
												<selectoption description="Operation.typeDeFrontEnd" value="1280"/>
												<selectoption description="Operation.typeDeMouvement" value="623"/>
												<selectoption description="Operation.typeDeMouvement" value="628"/>
												<selectoption description="Operation.typeDeTransactionAXALink" value="1281"/>
												<selectoption description="Organisation.appellation" value="1299"/>
												<selectoption description="Organisation.numeroDEntreprise" value="261"/>
												<selectoption description="Organisation.numeroDeTVA" value="1034"/>
												<selectoption description="Organisation.organisation" value="280"/>
												<selectoption description="ParkingAddress.codePostal" value="763"/>
												<selectoption description="ParkingAddress.entite" value="1118"/>
												<selectoption description="ParkingAddress.lettreDernierNumero" value="1204"/>
												<selectoption description="ParkingAddress.localite" value="762"/>
												<selectoption description="ParkingAddress.numero" value="1203"/>
												<selectoption description="ParkingAddress.numeroBoite" value="1202"/>
												<selectoption description="ParkingAddress.pays" value="764"/>
												<selectoption description="ParkingAddress.rue" value="761"/>
												<selectoption description="PartialSegmentationCoefficientPeriod.nom" value="981"/>
												<selectoption description="PartialSegmentationCoefficientPeriod.sequence" value="982"/>
												<selectoption description="PartialSegmentationCoefficientPeriod.valeur" value="1176"/>
												<selectoption description="Party.Genre" value="66"/>
												<selectoption description="Party.accordDirectMarketing" value="169"/>
												<selectoption description="Party.dateDEffet" value="248"/>
												<selectoption description="Party.dateDeFin" value="249"/>
												<selectoption description="Party.entite" value="1108"/>
												<selectoption description="Party.flagTVAAPayer" value="260"/>
												<selectoption description="Party.historique" value="290"/>
												<selectoption description="Party.langue" value="250"/>
												<selectoption description="Party.nom" value="264"/>
												<selectoption description="Party.numeroCIF" value="256"/>
												<selectoption description="Party.numeroDeClient" value="262"/>
												<selectoption description="PartyRole.affinity" value="101"/>
												<selectoption description="PartyRole.codeParentSouscriptionConducteur" value="1048"/>
												<selectoption description="PartyRole.codeParentSouscriptionConducteur[1]" value="1044"/>
												<selectoption description="PartyRole.codeParentSouscriptionConducteur[2]" value="1045"/>
												<selectoption description="PartyRole.codeParentSouscriptionConducteur[3]" value="1046"/>
												<selectoption description="PartyRole.codeParentSouscriptionConducteur[4]" value="1047"/>
												<selectoption description="PartyRole.codeParentSouscriptionConducteur[5]" value="1035"/>
												<selectoption description="PartyRole.entite" value="1102"/>
												<selectoption description="PartyRole.fonction" value="723"/>
												<selectoption description="PartyRole.fonctionCourrier" value="263"/>
												<selectoption description="PeriodRelease.chargesTotales" value="799"/>
												<selectoption description="PeriodRelease.commissionTotale" value="801"/>
												<selectoption description="PeriodRelease.dateDeDebut" value="795"/>
												<selectoption description="PeriodRelease.dateDeFin" value="796"/>
												<selectoption description="PeriodRelease.numeroDeFormule" value="794"/>
												<selectoption description="PeriodRelease.numeroDeSequence" value="792"/>
												<selectoption description="PeriodRelease.numeroDeSequenceDuRisque" value="793"/>
												<selectoption description="PeriodRelease.primeNetteTotale" value="798"/>
												<selectoption description="PeriodRelease.primeTotale" value="800"/>
												<selectoption description="PeriodRelease.typeDePeriode" value="797"/>
												<selectoption description="Person.categorieDePermisDeConduire" value="252"/>
												<selectoption description="Person.dateDeNaissance" value="54"/>
												<selectoption description="Person.dateDePermisDeConduire" value="64"/>
												<selectoption description="Person.entite" value="1095"/>
												<selectoption description="Person.nationalite" value="251"/>
												<selectoption description="Person.numeroNational" value="273"/>
												<selectoption description="Person.prefixe" value="254"/>
												<selectoption description="Person.prefixeTexteLibre" value="255"/>
												<selectoption description="Person.prenom" value="265"/>
												<selectoption description="Person.profession" value="56"/>
												<selectoption description="Person.sexe" value="55"/>
												<selectoption description="Person.typeConjoint" value="274"/>
												<selectoption description="Personalisation.dateDEffet" value="72"/>
												<selectoption description="Personalisation.dateDeFin" value="73"/>
												<selectoption description="Personalisation.dateProchaineReevaluation" value="106"/>
												<selectoption description="Personalisation.degre" value="71"/>
												<selectoption description="Personalisation.entite" value="1110"/>
												<selectoption description="Personalisation.intervention" value="302"/>
												<selectoption description="Personalisation.motifIntervention" value="104"/>
												<selectoption description="Personalisation.referenceLieeALEvolution" value="105"/>
												<selectoption description="Personalisation.type" value="70"/>
												<selectoption description="PersonalisationPeriod.coefficient" value="943"/>
												<selectoption description="PersonalisationPeriod.coefficientDePersonnalisationGlobal" value="944"/>
												<selectoption description="PersonalisationPeriod.dateDeReference" value="945"/>
												<selectoption description="PersonalisationPeriod.pourcentage" value="942"/>
												<selectoption description="PolicyHolder.compteBancaire" value="175"/>
												<selectoption description="PolicyHolder.deductibiliteTVA" value="102"/>
												<selectoption description="PolicyHolder.entite" value="1109"/>
												<selectoption description="PolicyHolder.packageSouscrit" value="660"/>
												<selectoption description="PolicyHolder.plusDe5VehiculesAssures" value="659"/>
												<selectoption description="PolicyHolder.pourcentageProbaPerteClient" value="258"/>
												<selectoption description="PolicyHolder.scoreCampagneApprocheClient" value="259"/>
												<selectoption description="PolicyHolder.scoreClientNormal" value="257"/>
												<selectoption description="PostalAddress.boite" value="269"/>
												<selectoption description="PostalAddress.codePostal" value="53"/>
												<selectoption description="PostalAddress.entite" value="1103"/>
												<selectoption description="PostalAddress.lettreDerriereNumero" value="268"/>
												<selectoption description="PostalAddress.localite" value="272"/>
												<selectoption description="PostalAddress.numero" value="267"/>
												<selectoption description="PostalAddress.numeroBoite" value="270"/>
												<selectoption description="PostalAddress.pays" value="1094"/>
												<selectoption description="PostalAddress.pays" value="1133"/>
												<selectoption description="PostalAddress.rue" value="266"/>
												<selectoption description="Premium.entite" value="1104"/>
												<selectoption description="Premium.primeDeBase" value="30"/>
												<selectoption description="Premium.type" value="29"/>
												<selectoption description="PrintAgreement.conditionsGeneralesAJoindre" value="135"/>
												<selectoption description="PrintAgreement.destinatairesDocuments" value="149"/>
												<selectoption description="PrintAgreement.impressionCP" value="145"/>
												<selectoption description="PrintAgreement.impressionComptant" value="147"/>
												<selectoption description="PrintAgreement.impressionDocumentsSupplementaires" value="150"/>
												<selectoption description="PrintAgreement.nombreDExemplairesCP" value="146"/>
												<selectoption description="PrintAgreement.nombreDExemplairesComptant" value="148"/>
												<selectoption description="PrintAgreement.nombreDExemplairesDocumentsSupplementaires" value="151"/>
												<selectoption description="PrintAgreement.typeDeLettre" value="974"/>
												<selectoption description="Relation.type" value="1279"/>
												<selectoption description="Release.calculManuAuto" value="648"/>
												<selectoption description="Release.chargementTotal" value="647"/>
												<selectoption description="Release.coutPolice" value="650"/>
												<selectoption description="Release.coutQuittance" value="651"/>
												<selectoption description="Release.dateDeCreation" value="630"/>
												<selectoption description="Release.dateDeDebut" value="631"/>
												<selectoption description="Release.dateDeFin" value="632"/>
												<selectoption description="Release.dateDeLEtat" value="634"/>
												<selectoption description="Release.dateDuDernierQuittancement" value="978"/>
												<selectoption description="Release.dateLettreRecommandee" value="638"/>
												<selectoption description="Release.dernierNumeroQuittanceComptant" value="977"/>
												<selectoption description="Release.destinataireDeLImprime" value="975"/>
												<selectoption description="Release.destinataireDuComptant" value="641"/>
												<selectoption description="Release.devise" value="652"/>
												<selectoption description="Release.etat" value="633"/>
												<selectoption description="Release.impressionDocumentComptant" value="639"/>
												<selectoption description="Release.impressionDocumentsSupplementaires" value="653"/>
												<selectoption description="Release.libelleLibrePasDeComptant" value="642"/>
												<selectoption description="Release.modeDEncaissement" value="636"/>
												<selectoption description="Release.montant" value="637"/>
												<selectoption description="Release.montantPrimeNetteTotale" value="646"/>
												<selectoption description="Release.montantTotalCommissionProducteur" value="1075"/>
												<selectoption description="Release.montantTotalCommissionProducteur[1]" value="1071"/>
												<selectoption description="Release.montantTotalCommissionProducteur[2]" value="1072"/>
												<selectoption description="Release.montantTotalCommissionProducteur[3]" value="1073"/>
												<selectoption description="Release.montantTotalCommissionProducteur[4]" value="1074"/>
												<selectoption description="Release.montantTotalCommissionProducteur[5]" value="645"/>
												<selectoption description="Release.motifDAnnulation" value="635"/>
												<selectoption description="Release.nombreDExemplairesDocumentsSupplementaires" value="654"/>
												<selectoption description="Release.nombreExDocumentComptantSupplementaires" value="640"/>
												<selectoption description="Release.numero" value="625"/>
												<selectoption description="Release.numeroCompteProducteur" value="1080"/>
												<selectoption description="Release.numeroCompteProducteur[1]" value="1076"/>
												<selectoption description="Release.numeroCompteProducteur[2]" value="1077"/>
												<selectoption description="Release.numeroCompteProducteur[3]" value="1078"/>
												<selectoption description="Release.numeroCompteProducteur[4]" value="1079"/>
												<selectoption description="Release.numeroCompteProducteur[5]" value="644"/>
												<selectoption description="Release.numeroDOrdre" value="626"/>
												<selectoption description="Release.numeroDeSequenceSituationContrat" value="627"/>
												<selectoption description="Release.pourcentageAppliqueSurCalculComptant" value="649"/>
												<selectoption description="Release.type" value="629"/>
												<selectoption description="Release.typeDeMouvement" value="1303"/>
												<selectoption description="Release.typeProducteur" value="1089"/>
												<selectoption description="Release.typeProducteur[1]" value="1085"/>
												<selectoption description="Release.typeProducteur[2]" value="1086"/>
												<selectoption description="Release.typeProducteur[3]" value="1087"/>
												<selectoption description="Release.typeProducteur[4]" value="1088"/>
												<selectoption description="Release.typeProducteur[5]" value="643"/>
												<selectoption description="ReleaseCalcul.batchExecute" value="881"/>
												<selectoption description="ReleaseCalcul.dateDEffet" value="876"/>
												<selectoption description="ReleaseCalcul.dateDeDemande" value="873"/>
												<selectoption description="ReleaseCalcul.dateDeFin" value="877"/>
												<selectoption description="ReleaseCalcul.heureDemande" value="880"/>
												<selectoption description="ReleaseCalcul.sequenceDeDemande" value="875"/>
												<selectoption description="ReleaseCalcul.typeDEncaissement" value="879"/>
												<selectoption description="ReleaseCalcul.typeDeCalcul" value="878"/>
												<selectoption description="ReleaseCalcul.typeDeDemande" value="874"/>
												<selectoption description="ResponsabilityCivil.classeDuRisque" value="778"/>
												<selectoption description="ResponsabilityCivil.qualiteAssurance" value="780"/>
												<selectoption description="ResponsabilityCivil.typeRC" value="1092"/>
												<selectoption description="ResponsabilityCivil.typeRC[1]" value="1090"/>
												<selectoption description="ResponsabilityCivil.typeRC[2]" value="1091"/>
												<selectoption description="ResponsabilityCivil.typeRC[3]" value="779"/>
												<selectoption description="ResponsabilitySingle.capitalUnique" value="784"/>
												<selectoption description="ResponsabilitySingle.classeDuRisque" value="781"/>
												<selectoption description="ResponsabilitySingle.nomBeneficiaire" value="782"/>
												<selectoption description="ResponsabilitySingle.typeDeCouverture" value="783"/>
												<selectoption description="RiskAddress.codePostal" value="759"/>
												<selectoption description="RiskAddress.entite" value="1117"/>
												<selectoption description="RiskAddress.lettreDernierNumero" value="1201"/>
												<selectoption description="RiskAddress.localite" value="758"/>
												<selectoption description="RiskAddress.numero" value="1200"/>
												<selectoption description="RiskAddress.numeroBoite" value="1199"/>
												<selectoption description="RiskAddress.pays" value="760"/>
												<selectoption description="RiskAddress.rue" value="757"/>
												<selectoption description="Segmentation.coefficientGlobalDeSegmentation" value="298"/>
												<selectoption description="Segmentation.coefficientImpose" value="110"/>
												<selectoption description="Segmentation.dateDEffet" value="619"/>
												<selectoption description="Segmentation.dateDeFin" value="620"/>
												<selectoption description="Segmentation.dateProchaineReevaluation" value="618"/>
												<selectoption description="Segmentation.degreDeSegmentation" value="107"/>
												<selectoption description="Segmentation.degreImpose" value="109"/>
												<selectoption description="Segmentation.intervention" value="228"/>
												<selectoption description="Segmentation.motifIntervention" value="229"/>
												<selectoption description="Segmentation.nombreDePoints" value="108"/>
												<selectoption description="Segmentation.nombreDePointsDeroges" value="112"/>
												<selectoption description="Segmentation.referenceLieeALEvolution" value="902"/>
												<selectoption description="Segmentation.tarifPlafonne" value="111"/>
												<selectoption description="Segmentation.type" value="227"/>
												<selectoption description="SegmentationCriterium.nom" value="232"/>
												<selectoption description="SegmentationCriterium.traitementDeLaValeur" value="115"/>
												<selectoption description="SegmentationCriterium.typeDeValeur" value="117"/>
												<selectoption description="SegmentationCriterium.valeur" value="233"/>
												<selectoption description="SegmentationCriteriumPeriod.modifiable" value="938"/>
												<selectoption description="SegmentationCriteriumPeriod.nom" value="935"/>
												<selectoption description="SegmentationCriteriumPeriod.sequence" value="941"/>
												<selectoption description="SegmentationCriteriumPeriod.traitementDeLaValeur" value="940"/>
												<selectoption description="SegmentationCriteriumPeriod.typeDeValeur" value="936"/>
												<selectoption description="SegmentationCriteriumPeriod.valeur" value="937"/>
												<selectoption description="SegmentationCriteriumPeriod.valeurParDefaut" value="939"/>
												<selectoption description="SegmentationPartial.entite" value="1259"/>
												<selectoption description="SegmentationPartial.nomCoefficientDetail" value="114"/>
												<selectoption description="SegmentationPartial.valeurCoefficientDetail" value="231"/>
												<selectoption description="SegmentationPeriod.coefficientDeSegmentationGlobal" value="929"/>
												<selectoption description="SegmentationPeriod.conservationDerogationPermanente" value="932"/>
												<selectoption description="SegmentationPeriod.conservationDerogationTemporaire" value="933"/>
												<selectoption description="SegmentationPeriod.dateDeReference" value="930"/>
												<selectoption description="SegmentationPeriod.intervention" value="968"/>
												<selectoption description="SegmentationPeriod.reactualisation" value="931"/>
												<selectoption description="Specification.entite" value="1105"/>
												<selectoption description="Specification.formule" value="12"/>
												<selectoption description="Specification.gamme" value="908"/>
												<selectoption description="Specification.label" value="909"/>
												<selectoption description="Specification.produit" value="96"/>
												<selectoption description="TariffAdjustementPeriod.dateDEffet" value="947"/>
												<selectoption description="TariffAdjustementPeriod.dateDeFin" value="951"/>
												<selectoption description="TariffAdjustementPeriod.dateDeTarification" value="946"/>
												<selectoption description="TariffAdjustementPeriod.qualificatifDeLaValeur" value="948"/>
												<selectoption description="TariffAdjustementPeriod.typeDePrime" value="950"/>
												<selectoption description="TariffAdjustementPeriod.valeur" value="949"/>
												<selectoption description="TariffAdjustment.dateDEffet" value="1304"/>
												<selectoption description="TariffAdjustment.dateDeFin" value="118"/>
												<selectoption description="TariffAdjustment.dateDeTarification" value="38"/>
												<selectoption description="TariffAdjustment.qualificatifDeLaValeur" value="78"/>
												<selectoption description="TariffAdjustment.typeDePrime" value="77"/>
												<selectoption description="TariffAdjustment.valeur" value="79"/>
												<selectoption description="TariffCommission.calculManuelAuto" value="124"/>
												<selectoption description="TariffCommission.dateDEffet" value="299"/>
												<selectoption description="TariffCommission.dateDeFin" value="300"/>
												<selectoption description="TariffCommission.montantDeBaseCommissionIndexee" value="301"/>
												<selectoption description="TariffCommission.numeroDeCompteProducteur" value="120"/>
												<selectoption description="TariffCommission.qualificatifDeLaCommissionIndexee" value="83"/>
												<selectoption description="TariffCommission.qualificatifDeLaRetrocessionIndexee" value="181"/>
												<selectoption description="TariffCommission.typeDeCommission" value="121"/>
												<selectoption description="TariffCommission.typeDeProducteur" value="119"/>
												<selectoption description="TariffCommission.typeDeRetrocessionIndexee" value="126"/>
												<selectoption description="TariffCommission.valeurDeLaCommissionIndexee" value="15"/>
												<selectoption description="TariffCommission.valeurDeLaRetrocessionIndexee" value="13"/>
												<selectoption description="TariffCommissionPeriod.resultatCommission" value="847"/>
												<selectoption description="TariffCommissionPeriod.resultatRetrocession" value="848"/>
												<selectoption description="TariffCommissionSubPeriod.resultatCommission" value="926"/>
												<selectoption description="TariffCommissionSubPeriod.resultatRetrocession" value="927"/>
												<selectoption description="TariffCommissionTotalsForAgreement.commissionTotale" value="833"/>
												<selectoption description="TariffCommissionTotalsForAgreement.numeroDeCompteProducteur" value="832"/>
												<selectoption description="TariffCommissionTotalsForAgreement.retrocessionTotale" value="834"/>
												<selectoption description="TariffIdentifier.dateRelease" value="959"/>
												<selectoption description="TariffIdentifier.gamme" value="956"/>
												<selectoption description="TariffIdentifier.label" value="957"/>
												<selectoption description="TariffIdentifier.produit" value="958"/>
												<selectoption description="ThirdPartyCompany.aperiteur" value="670"/>
												<selectoption description="ThirdPartyCompany.dateDEffet" value="76"/>
												<selectoption description="ThirdPartyCompany.dateDeFin" value="667"/>
												<selectoption description="ThirdPartyCompany.entite" value="1111"/>
												<selectoption description="ThirdPartyCompany.numeroDeCompagnieCreancier" value="672"/>
												<selectoption description="ThirdPartyCompany.numeroDePoliceCollective" value="669"/>
												<selectoption description="ThirdPartyCompany.policeCollective" value="668"/>
												<selectoption description="ThirdPartyCompany.referenceChezCompagnieCreancier" value="673"/>
												<selectoption description="ThirdPartyCompany.tauxDeRepartitionCoassurance" value="674"/>
												<selectoption description="ThirdPartyCompany.typeDIntervenant" value="671"/>
												<selectoption description="Vehicle.antivol" value="223"/>
												<selectoption description="Vehicle.carburant" value="42"/>
												<selectoption description="Vehicle.categorieDeTransport" value="34"/>
												<selectoption description="Vehicle.cylindree" value="31"/>
												<selectoption description="Vehicle.dateDAchat" value="130"/>
												<selectoption description="Vehicle.dateDeConstruction" value="190"/>
												<selectoption description="Vehicle.dateDePremiereMiseEnCirculation" value="50"/>
												<selectoption description="Vehicle.dateKilometrage" value="657"/>
												<selectoption description="Vehicle.entite" value="1106"/>
												<selectoption description="Vehicle.factureDAchat" value="236"/>
												<selectoption description="Vehicle.garageDeNuit" value="234"/>
												<selectoption description="Vehicle.genre" value="47"/>
												<selectoption description="Vehicle.kilometrage" value="656"/>
												<selectoption description="Vehicle.masseMaximaleAutorisee" value="51"/>
												<selectoption description="Vehicle.montantDuMobilophone" value="903"/>
												<selectoption description="Vehicle.nombreDAnneesDePossession" value="791"/>
												<selectoption description="Vehicle.nombreDAnneesSansSinistre" value="128"/>
												<selectoption description="Vehicle.nombreDePlaces" value="46"/>
												<selectoption description="Vehicle.nombreKmAParcourir" value="197"/>
												<selectoption description="Vehicle.numeroDeChassis" value="189"/>
												<selectoption description="Vehicle.numeroDePlaque1" value="191"/>
												<selectoption description="Vehicle.numeroDePlaque2" value="193"/>
												<selectoption description="Vehicle.particulariteDeGestionTexte" value="221"/>
												<selectoption description="Vehicle.poidsAVide" value="195"/>
												<selectoption description="Vehicle.pourcentageEcartValCatalogueValAssuree" value="196"/>
												<selectoption description="Vehicle.produitsDangereuxTransportes" value="45"/>
												<selectoption description="Vehicle.puissance" value="242"/>
												<selectoption description="Vehicle.traction" value="32"/>
												<selectoption description="Vehicle.type" value="49"/>
												<selectoption description="Vehicle.typeDeCirculation" value="224"/>
												<selectoption description="Vehicle.typeDePlaque1" value="37"/>
												<selectoption description="Vehicle.typeDePlaque2" value="192"/>
												<selectoption description="Vehicle.typeDeTarificationRemorque" value="52"/>
												<selectoption description="Vehicle.typeDeValorisation" value="199"/>
												<selectoption description="Vehicle.usage" value="48"/>
												<selectoption description="Vehicle.valeurAssuree" value="43"/>
												<selectoption description="Vehicle.valeurAssureeGlobalCar" value="820"/>
												<selectoption description="Vehicle.valeurCatalogueAvecOptions" value="44"/>
												<selectoption description="Vehicle.valeurCatalogueSansPlus" value="198"/>
												<selectoption description="Vehicle.valeurDesAccessoires" value="41"/>
												<selectoption description="Vehicle.valeurExpertise" value="201"/>
												<selectoption description="Vehicle.valeurMaximumBagages" value="202"/>
												<selectoption description="Vehicle.valeurPremierRisque" value="36"/>
												<selectoption description="Vehicle.valeurVitrage" value="203"/>
												<selectoption description="Vehicle.versionTexteLibre" value="129"/>
												<selectoption description="VehiclePremiumCalculation.age" value="924"/>
												<selectoption description="VehiclePremiumCalculation.caracteristiques" value="1177"/>
												<selectoption description="VehiclePremiumCalculation.rapportPoidsPuissance" value="925"/>
												<selectoption description="VehiclePremiumCalculation.typePuissanceCylindree" value="1178"/>
												<selectoption description="VehicleReference.libelleMarque" value="239"/>
												<selectoption description="VehicleReference.libelleModele" value="240"/>
												<selectoption description="VehicleReference.libelleVersion" value="241"/>
												<selectoption description="VehicleReference.rapportPuissancePoids" value="1210"/>
											</combobox>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<text fixtext="}">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="placeHolderList">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="placeHolderList">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="{">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<text fixtext="list">
								<editorproperties/>
								<properties/>
								<styles font-weight="bold"/>
								<children/>
							</text>
							<template match="listAgreement">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<text fixtext=" Agreement values = ">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<template match="listGeneral">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<text fixtext=" General list = ">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext=" ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="listRestricted">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<text fixtext=" Restricted list = ">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<template match="label">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<text fixtext=" Label = ">
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</text>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext="}">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="placeHolderValue">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="placeHolderValue">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="{">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<text fixtext="value">
								<editorproperties/>
								<properties/>
								<styles font-weight="bold"/>
								<children/>
							</text>
							<text fixtext=" ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<template match="expression">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<properties/>
								<styles/>
								<children>
									<content>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<addvalidations/>
										<format/>
									</content>
								</children>
								<addvalidations/>
								<sort/>
							</template>
							<text fixtext="}">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="p">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="p">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<content>
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
								<addvalidations/>
								<format/>
							</content>
							<condition>
								<editorproperties/>
								<properties/>
								<styles/>
								<children>
									<conditionbranch xpath="position() &lt; last()">
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="var">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="var">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext="var(">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<content>
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
								<addvalidations/>
								<format datatype="anyType"/>
							</content>
							<text fixtext=")">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="action">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="action">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<properties/>
						<styles/>
						<children>
							<text fixtext=" ">
								<editorproperties/>
								<properties/>
								<styles/>
								<children/>
							</text>
							<table>
								<editorproperties/>
								<properties border="1" width="100%"/>
								<styles/>
								<children>
									<tablebody>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<tablerow>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<tablecell>
														<editorproperties/>
														<properties width="237"/>
														<styles/>
														<children>
															<template match="@type">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox enumeration="1">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
															<template match="errorCode">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<properties/>
																<styles/>
																<children>
																	<combobox xpath="doc(&quot;ErrorCodes.xml&quot;)/errorCodesTable/errorCodeDefinition/errorCodeValue">
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</combobox>
																</children>
																<addvalidations/>
																<sort/>
															</template>
														</children>
													</tablecell>
													<tablecell>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<table>
																<editorproperties/>
																<properties border="1"/>
																<styles/>
																<children>
																	<tablebody>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<template match="contexts">
																				<editorproperties elementstodisplay="1" elementstofetch="all"/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablerow>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablecell>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<content match="context">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children/>
																										<addvalidations/>
																										<format/>
																									</content>
																								</children>
																							</tablecell>
																						</children>
																					</tablerow>
																				</children>
																				<addvalidations/>
																				<sort/>
																			</template>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
						<addvalidations/>
						<sort/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</parts>
	<pagelayout>
		<editorproperties/>
		<properties/>
		<styles/>
		<children/>
	</pagelayout>
</structure>
