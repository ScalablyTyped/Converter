import { FormProps as RcFormProps } from 'rc-field-form/es/Form';

export interface FormProps extends Omit<RcFormProps, 'form'> {
    prefixCls?: string;
}
