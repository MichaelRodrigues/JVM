#include "fieldinfo.h"

static uint16_t getAccessFlags(DADOS* d) {
	return d->le2Bytes(d);
}

static uint16_t getNameIndex(DADOS* d) {
	return d->le2Bytes(d);
}

static uint16_t getDescriptorIndex(DADOS* d) {
	return d->le2Bytes(d);
}

static uint16_t getAttributesCount(DADOS* d) {
	return d->le2Bytes(d);
}

static int addField(FIELD_POOL* this, CONSTANT_POOL* cp, int ordem, DADOS* d) {
	
	this->fields[ordem].access_flags = getAccessFlags(d);
	this->fields[ordem].name_index = getNameIndex(d);
	this->fields[ordem].descriptor_index = getDescriptorIndex(d);
	this->fields[ordem].attributes_count = getAttributesCount(d);
	this->fields[ordem].value = 0;

	ATTRIBUTE_POOL* field_attributes = initATTRIBUTE_POOL(this->fields[ordem].attributes_count);
	for(int i =0; i<this->fields[ordem].attributes_count; i++){
		field_attributes->addAttribute(field_attributes, cp, i, d);
	}
	this->fields[ordem].attributes = field_attributes->attributes;

	return E_SUCCESS;
}

FIELD_POOL* initFIELD_POOL(int count) {
	FIELD_POOL* toReturn = (FIELD_POOL*)malloc(sizeof(FIELD_POOL));

	toReturn->fields = (struct _field_info*)malloc((count)*sizeof(struct _field_info));
	toReturn->addField = addField;
	return toReturn;
}