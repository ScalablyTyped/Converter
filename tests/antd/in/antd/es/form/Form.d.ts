import { FormProps as RcFormProps } from 'rc-field-form/lib/Form';

export interface FormProps extends Omit<RcFormProps, 'form'> {
    prefixCls?: string;
}
