import run from './lib/run';
declare const MailSpellChecker: {
    run: typeof run;
    POPULAR_DOMAINS: string[];
    POPULAR_TLDS: string[];
};
export { run };
export default MailSpellChecker;
